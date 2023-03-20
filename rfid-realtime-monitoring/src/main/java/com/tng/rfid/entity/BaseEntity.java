package com.tng.rfid.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Column(updatable = false)
    protected Date createDate;

    @Column(updatable = false)
    protected String createdBy;

    @Column
    protected Date lastModifiedDate;

    @Column
    protected String lastModifiedBy;

    @Column
    protected Boolean active;

    @Column
    protected Boolean deleted;
}
