package com.zlrx.database.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

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

    private List<Programmer> programmers;

}
