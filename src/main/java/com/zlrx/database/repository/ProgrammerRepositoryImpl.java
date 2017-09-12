package com.zlrx.database.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProgrammerRepositoryImpl implements CustomProgrammerRepository {

    @PersistenceContext
    private EntityManager entityManager;


}
