package com.zlrx.database.repository;

import com.zlrx.database.domain.Phone;
import com.zlrx.database.domain.Programmer;
import org.jinq.tuples.Pair;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.List;

@NoRepositoryBean
public interface CustomProgrammerRepository {

    List<Programmer> findAllSenior();

    String findNameByIdNumber(String idNumber);

    List<Programmer> findDynamically(String name, String idNumber);

    List<Programmer> findSalaryBelowFifty();

    List<Pair<Programmer, Phone>> findPhoneJoin();

    List<Phone> findProgrammerPhones(String name, String phoneType);

    Double calculateAverageSalary();

    Long countProgrammersInDatabase();

    Long calculateSumOfSalary();

    Integer findBestSalary();

    List<String> findProgrammerNamesOrderByName();

    List<String> findDistinctProgrammerNames();

    List<Programmer> findByNameLike();

    List<Programmer> findJavaUsers();

    List<Programmer> createdBefore(LocalDateTime date);

    List<Programmer> findAllWithJinq();

}
