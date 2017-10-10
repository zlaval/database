package com.zlrx.database.config;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Component
public class JinqSource {

    private JinqJPAStreamProvider streamProvider;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    private void init() {
        streamProvider = new JinqJPAStreamProvider(entityManagerFactory);
    }

    public <E> JPAJinqStream<E> stream(Class<E> entity) {
        return streamProvider.streamAll(entityManager, entity);
    }

}
