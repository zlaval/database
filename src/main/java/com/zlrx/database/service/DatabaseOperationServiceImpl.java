package com.zlrx.database.service;

import com.zlrx.database.domain.Address;
import com.zlrx.database.domain.Programmer;
import com.zlrx.database.pojo.ProgrammerNameAndCity;
import com.zlrx.database.repository.AddressRepository;
import com.zlrx.database.repository.PhoneRepository;
import com.zlrx.database.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DatabaseOperationServiceImpl implements DatabaseOperationService {

    @Autowired
    private ProgrammerRepository programmerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void doAllDatabaseOperation() {
        Address address = new Address();
        address.setCity("Mucsarocsoge");
        address.setHouseNumber(1);
        address.setStreet("New Street");
        address.setZip(1083);
        Address savedAddress = addressRepository.save(address);

        Programmer programmer = new Programmer();
        programmer.setSenior(true);
        programmer.setName("Joe Doe");
        programmer.setIdNumber("123");
        programmer.setAddress(savedAddress);
        programmerRepository.save(programmer);
        programmerRepository.findAll();

        ProgrammerNameAndCity nac = programmerRepository.findNameAndCityByIdNumber("123");

        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "name");
        Sort sort = new Sort(order);
        programmerRepository.findByName("Joe Doe", sort);


        System.out.println();
    }
}
