package com.zlrx.database.repository;

import com.zlrx.database.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String>, CustomAddressRepository {

    List<Address> findByCityAndStreet(String city, String street);

    List<Address> findByCityOrderByCity(String city);

    List<Address> findByHouseNumberBetween(Integer min, Integer max);

    List<Address> findByCityIn(List<String> city);

    List<Address> findByHouseNumberGreaterThan(Integer min);

    Address findByProgrammerName(String name);

}

