package com.zlrx.database.repository;

import com.zlrx.database.domain.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class AddressRepositoryImpl implements CustomAddressRepository {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Address> findAllMatch(Integer zip, String city, String street, Integer houseNumber) {
        StringBuilder sql = new StringBuilder(" select a from Address a where 1=1 ");
        addSqlSnippet("zip", zip, sql);
        addSqlSnippet("city", city, sql);
        addSqlSnippet("street", street, sql);
        addSqlSnippet("houseNumber", houseNumber, sql);
        sql.append(" order by a.city ");

        TypedQuery<Address> query = entityManager.createQuery(sql.toString(), Address.class);

        addParameter("zip", zip, query);
        addParameter("city", city, query);
        addParameter("street", street, query);
        addParameter("houseNumber", houseNumber, query);

        return query.getResultList();
    }

    private <T> void addParameter(String name, T value, TypedQuery<Address> query) {
        if (Objects.nonNull(value)) {
            query.setParameter(name, value);
        }
    }

    private <T> void addSqlSnippet(String name, T value, StringBuilder sql) {
        if (Objects.nonNull(value)) {
            sql.append(" and a.").append(name).append("=:").append(name);
        }
    }
}
