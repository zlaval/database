package com.zlrx.database.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class ProgrammingLanguage extends BaseEntity {

    @Basic
    private String name;

    @Basic
    private String inventor;

    @Column(name = "release_date")
    private LocalDate release;

}
