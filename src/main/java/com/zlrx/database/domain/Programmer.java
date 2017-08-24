package com.zlrx.database.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRAMMER")
public class Programmer extends BaseEntity {

    @Basic
    private String name;


    //TODO Address one to many
    //TODO Phone   many to one
    //TODO ProgLang many to many
}
