package com.zlrx.database.repository;

import com.zlrx.database.domain.Phone;
import com.zlrx.database.domain.Programmer;
import org.jinq.tuples.Pair;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CustomProgrammerRepository {

    List<Programmer> findAllSenior();

    String findNameByIdNumber(String idNumber);

    List<Programmer> findDynamically(String name, String idNumber);

    List<Programmer> findSalaryBelowFifty();

    List<Pair<Programmer, Phone>> findPhoneJoin();

    List<Phone> getProgrammerPhones(String name,String phoneType);


}
