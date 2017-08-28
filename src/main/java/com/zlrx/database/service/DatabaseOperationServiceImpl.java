package com.zlrx.database.service;

import com.zlrx.database.domain.Address;
import com.zlrx.database.domain.Programmer;
import com.zlrx.database.repository.AddressRepository;
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


    @Override
    public void operate() {
        Programmer programmer = programmerRepository.findOne("1");
        //programmerRepository.delete(programmer);
        Address address = addressRepository.findOne("3");
        //  addressRepository.delete(address);
        programmer.setAddress(address);
        programmerRepository.save(programmer);

        //TODO:
        //ha kiveszek egy telefont torlodik a telefon
        //ha kiveszek egy programozási nyelvet törlődik a kapcsolat
        //ha törlök egy telefont törlődik a kapcsolat
        //ha eltavolitok egy addresst a programernek meg kell maradnia
        //ha attallitom a programer addrest uj addressre a reginek torlodnie kell

    }
}
