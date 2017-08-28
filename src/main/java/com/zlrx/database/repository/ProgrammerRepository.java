package com.zlrx.database.repository;

import com.zlrx.database.domain.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer,String> {

}
