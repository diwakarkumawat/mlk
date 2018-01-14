package com.mlk.fun.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class CharityGoal extends BaseDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Charity> charities;
}
