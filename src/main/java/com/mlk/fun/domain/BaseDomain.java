package com.mlk.fun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseDomain implements Serializable {

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dateCreated;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dateUpdated;

    @PrePersist
    public void prePersist() {
        createTimeStamp();
    }

    @PreUpdate
    public void preUpdate() {
        this.dateUpdated = new Date();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    void createTimeStamp() {
        Date timestamp = new Date();
        this.dateCreated = timestamp;
        this.dateUpdated = timestamp;
    }
}
