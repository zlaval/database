package com.zlrx.database.service;

import com.zlrx.database.domain.Address;
import com.zlrx.database.repository.AddressRepository;
import com.zlrx.database.repository.PhoneRepository;
import com.zlrx.database.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        address.setCity("Budapest");
        address.setHouseNumber(1);
        address.setStreet("Szigony");
        address.setZip(1083);
        addressRepository.save(address);

        Address address2 = new Address();
        address2.setCity("Budapest");
        address2.setHouseNumber(5);
        address2.setStreet("Szigony");
        address2.setZip(1083);
        addressRepository.save(address2);

        List<Address> r1 = addressRepository.findAllMatch(1083, "Budapest", "Szigony", null);
        List<Address> r2 = addressRepository.findAllMatch(1083, null, null, 1);
        List<Address> r3 = addressRepository.findAllMatch(1083, null, null, null);
        System.out.println();
    }
}
