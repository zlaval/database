package com.zlrx.database.repository;

import com.zlrx.database.domain.Phone;
import com.zlrx.database.domain.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, String> {

    List<Phone> findByOwner(Programmer programmer);

    @Query("select p from Phone p where p.imei=?1")
    Phone findByImei(String imei);

    @Query("select p from Phone p where p.type=:tp")
    List<Phone> findByType(@Param("tp") String type);

    @Query(value = "select * from phone where imei=?1", nativeQuery = true)
    Phone findByImeiNative(String imei);

    @Modifying
    @Query("update Phone p set p.price=?1 where p.imei=?2")
    void updatePriceByImei(Double price, String imei);


}
