package com.zlrx.database.domain;

import com.zlrx.database.utility.IdGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false, length = 32)
    protected String id = IdGenerator.generateId();

    @Version
    protected Long version;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    protected LocalDateTime updatedAt;

    @PreUpdate
    protected void preUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }

    @PrePersist
    protected void prePersist() {
        setCreatedAt(LocalDateTime.now());
        preUpdate();
    }

    @Transient
    public boolean isNew() {
        return Objects.isNull(version);
    }

}
