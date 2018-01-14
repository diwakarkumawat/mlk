package com.mlk.fun.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseDomain implements Serializable {

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @PrePersist
    public void prePersist() {
        createTimeStamp();
    }

    @PreUpdate
    public void preUpdate() {
        this.dateUpdated = new Date();
    }

    void createTimeStamp() {
        Date timestamp = new Date();
        this.dateCreated = timestamp;
        this.dateUpdated = timestamp;
    }
}
