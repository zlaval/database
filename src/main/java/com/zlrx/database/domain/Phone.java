package com.zlrx.database.domain;

import com.zlrx.database.enums.Producer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Phone extends BaseEntity {

    @Basic(optional = false)
    @Enumerated(value = EnumType.STRING)
    private Producer producer;

    @Basic
    private String type;

    @Column(name = "imei", length = 50, nullable = false, unique = true)
    private String imei;

    @Column(name = "price", nullable = false, precision = 2)
    private Double price;

    private Programmer owner;

}
