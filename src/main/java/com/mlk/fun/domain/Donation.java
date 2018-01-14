package com.mlk.fun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
public class Donation extends BaseDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal amount;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date donationDate;

    @Column
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Donor> donor = new HashSet<>();

    @Column
    @OneToMany
    private Set<Charity> charity = new HashSet<>();

}
