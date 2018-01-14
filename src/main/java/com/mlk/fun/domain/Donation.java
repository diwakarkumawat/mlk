package com.mlk.fun.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
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
    private Date donationDate;

    @Column
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Donor> donor;

    @Column
    @OneToMany
    private Set<Charity> charity;

}
