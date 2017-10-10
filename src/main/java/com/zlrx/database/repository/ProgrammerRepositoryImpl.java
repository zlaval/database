package com.zlrx.database.repository;

import com.zlrx.database.config.JinqSource;
import com.zlrx.database.domain.Phone;
import com.zlrx.database.domain.Programmer;
import org.jinq.orm.stream.JinqStream;
import org.jinq.tuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class ProgrammerRepositoryImpl implements CustomProgrammerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JinqSource source;

    @PostConstruct
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

    public List<Pair<Programmer, Phone>> findPhoneJoin() {
        return stream()
                .join((programmer, source) -> source.stream(Phone.class))
                .toList();

    }

    public List<Phone> getProgrammerPhones(String name, String phoneType) {
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
}
