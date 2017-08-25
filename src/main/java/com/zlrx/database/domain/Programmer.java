package com.zlrx.database.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PROGRAMMER")
public class Programmer extends BaseEntity {

    @Basic
    private String name;

    //hibernate specific
    @Type(type = "yes_no")
    private Boolean senior;

    private Address address;

    private List<Phone> phones;

    private List<ProgrammingLanguage> programmingLanguages;



    //TODO Address one to many
    //TODO Phone   many to one
    //TODO ProgLang many to many
}
