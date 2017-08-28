package com.zlrx.database.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "programmer")
public class Programmer extends BaseEntity {

    @Basic
    private String name;

    //hibernate specific
    @Type(type = "yes_no")
    private Boolean senior;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "owner")
    private List<Phone> phones;

    @ManyToMany
    @JoinTable(name = "programmer_to_proglanguage",
            joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "prog_lang_id", referencedColumnName = "id"))
    private List<ProgrammingLanguage> programmingLanguages;

}
