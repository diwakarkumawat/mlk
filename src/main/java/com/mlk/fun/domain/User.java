package com.mlk.fun.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String addressLine1;

}
