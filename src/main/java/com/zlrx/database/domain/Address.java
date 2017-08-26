package com.zlrx.database.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Address extends BaseEntity {

    @Basic
    private Integer zip;

    @Basic
    private String city;

    @Basic
    private String street;

    @Column(name = "house_number")
    private Integer houseNumber;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Programmer programmer;

}
