package com.mlk.fun.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class CharityGoal extends BaseDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @ManyToMany
    @JsonIgnore
    private Set<Charity> charities;

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

    public Set<Charity> getCharities() {
        return charities;
    }

    public void setCharities(Set<Charity> charities) {
        this.charities = charities;
    }
}
