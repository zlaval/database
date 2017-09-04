package com.zlrx.database.repository;

import com.zlrx.database.domain.Phone;
import com.zlrx.database.domain.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, String> {

    List<Phone> findByOwner(Programmer programmer);




}
