package com.zlrx.database.repository;

import com.zlrx.database.domain.Programmer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammerRepository extends JpaRepository<Programmer, String> {

    Programmer findByName(String name);

    List<Programmer> findBySeniorTrue();

    List<Programmer> findAll(Sort sort);

}
