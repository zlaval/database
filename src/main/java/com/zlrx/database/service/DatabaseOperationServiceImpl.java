package com.zlrx.database.service;

import com.zlrx.database.repository.AddressRepository;
import com.zlrx.database.repository.PhoneRepository;
import com.zlrx.database.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    }
}
