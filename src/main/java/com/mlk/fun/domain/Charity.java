package com.mlk.fun.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Charity extends BaseDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "charities")
    private Set<CharityGoal> charityGoals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CharityGoal> getCharityGoals() {
        return charityGoals;
    }

    public void setCharityGoals(Set<CharityGoal> charityGoals) {
        this.charityGoals = charityGoals;
    }
}
