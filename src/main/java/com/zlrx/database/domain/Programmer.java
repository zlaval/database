package com.zlrx.database.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    @OneToOne
    private Address address;

    @OneToMany
    private List<Phone> phones;

    @ManyToMany
    private List<ProgrammingLanguage> programmingLanguages;


}
