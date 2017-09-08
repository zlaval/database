package com.zlrx.database.service;

import com.zlrx.database.domain.Address;
import com.zlrx.database.domain.Programmer;
import com.zlrx.database.pojo.ProgrammerNameAndCity;
import com.zlrx.database.repository.AddressRepository;
import com.zlrx.database.repository.PhoneRepository;
import com.zlrx.database.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
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

        Programmer programmer2 = new Programmer();
        programmer2.setSenior(true);
        programmer2.setName("Joe Doe");
        programmer2.setIdNumber("1234");
        programmerRepository.save(programmer2);

        Programmer programmer3 = new Programmer();
        programmer3.setSenior(true);
        programmer3.setName("Joe Doe");
        programmer3.setIdNumber("1235");
        programmerRepository.save(programmer3);

        Pageable pageable = new PageRequest(0, 2);
        Page<Programmer> programers = programmerRepository.findByName("Joe Doe", pageable);
        long elements = programers.getTotalElements();
        long totalPages = programers.getTotalPages();
        Iterator<Programmer> it = programers.iterator();
        it.forEachRemaining(p -> System.out.println(p.getIdNumber()));

        Address address1=addressRepository.findByProgrammerName("Joe Doe");

        System.out.println();
    }
}
