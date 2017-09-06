package com.zlrx.database.repository;

import com.zlrx.database.domain.Address;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CustomAddressRepository {

    List<Address> findAllMatch(Integer zip,String city,String street,Integer houseNumber);

}
