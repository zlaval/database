package com.zlrx.database.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @Basic
    private Integer houseNumber;

    @OneToOne
    private Programmer programmer;

}
