package com.zlrx.database.repository;

import com.zlrx.database.domain.Programmer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammerRepository extends JpaRepository<Programmer, String> {

    List<Programmer> findBySeniorTrue();

    List<Programmer> findByName(String name);

    List<Programmer> findByName(String name, Sort sort);

    List<Programmer> findByName(String name, Pageable pageable);

    Programmer findByIdNumber(String idNumber);

}
