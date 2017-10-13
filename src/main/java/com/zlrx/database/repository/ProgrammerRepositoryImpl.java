package com.zlrx.database.repository;

import com.zlrx.database.config.JinqSource;
import com.zlrx.database.domain.Phone;
import com.zlrx.database.domain.Programmer;
import com.zlrx.database.domain.ProgrammingLanguage;
import org.jinq.jpa.JPQL;
import org.jinq.orm.stream.JinqStream;
import org.jinq.tuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Repository
public class ProgrammerRepositoryImpl implements CustomProgrammerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JinqSource source;

    private JinqStream<Programmer> stream() {
        return source.stream(Programmer.class);
    }

    @Override
    public List<Programmer> findAllSenior() {
        return stream().where(p -> p.getSenior().equals(true)).toList();
    }

    @Override
    public String findNameByIdNumber(String idNumber) {
        return stream().where(p -> p.getIdNumber().equals(idNumber))
                .select(Programmer::getName)
                .getOnlyValue();
    }

    @Override
    public List<Programmer> findDynamically(String name, String idNumber) {
        JinqStream<Programmer> stream = stream();
        if (Objects.nonNull(name)) {
            stream = stream.where(p -> p.getName().equals(name));
        }
        if (Objects.nonNull(idNumber)) {
            stream = stream.where(p -> p.getIdNumber().equals(idNumber));
        }
        return stream.toList();
    }

    @Override
    public List<Programmer> findSalaryBelowFifty() {
        return stream().where(p -> p.getSalary() < 50_000).toList();
    }

    @Override
    public List<Pair<Programmer, Phone>> findPhoneJoin() {
        return stream()
                .join((programmer, source) -> source.stream(Phone.class))
                .toList();

    }

    @Override
    public List<Phone> findProgrammerPhones(String name, String phoneType) {
//        return stream().where(p -> p.getName().equals(name))
//                .leftOuterJoin(p -> JinqStream.from(p.getPhones()))
//                .select(Pair::getTwo)
//                .where(p -> p.getType().equals(phoneType))
//                .toList();
//selectAll=join+select
        return stream().where(programmer -> programmer.getName().equals(name))
                .selectAllList(Programmer::getPhones)
                .where(phone -> phone.getType().equals(phoneType))
                .toList();
    }

    @Override
    public Double calculateAverageSalary() {
        return stream().avg(Programmer::getSalary);
    }

    @Override
    public Long countProgrammersInDatabase() {
        return stream().count();
    }

    @Override
    public Long calculateSumOfSalary() {
        return stream().sumInteger(Programmer::getSalary);
    }

    @Override
    public Integer findBestSalary() {
        return stream().max(Programmer::getSalary);
    }

    @Override
    public List<String> findProgrammerNamesOrderByName() {
        return stream().select(Programmer::getName).sortedBy(e -> e).toList();
    }

    @Override
    public List<String> findDistinctProgrammerNames() {
        return stream().select(Programmer::getName).distinct().toList();
    }

    @Override
    public List<Programmer> findByNameLike() {
        return stream()
                .where(p -> p.getName().startsWith("Jo") || p.getName().startsWith("Ja"))
                .toList();
    }

    @Override
    public List<Programmer> findJavaUsers() {
        return stream().where(p ->
                JPQL.isIn("Java",
                        JinqStream.from(p.getProgrammingLanguages())
                                .select(ProgrammingLanguage::getName)
                )
        ).toList();
    }

    @Override
    public List<Programmer> createdBefore(LocalDateTime date) {
        return stream().where(p -> p.getCreatedAt().isBefore(date)).toList();
    }


}
