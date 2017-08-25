package com.zlrx.database.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table
public class ProgrammingLanguage extends BaseEntity {

    @Basic
    private String name;

    @Basic
    private Optional<String> inventor;

    @Basic
    private LocalDate release;

    private List<Programmer> users;

}
