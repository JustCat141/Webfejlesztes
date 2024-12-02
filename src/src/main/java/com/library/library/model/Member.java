package com.library.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Member extends ObjectModel {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(unique = true, nullable = false)
    private String firstName;

    @Column(unique = true, nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private OffsetDateTime birthDate;

    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> bookLoans = new ArrayList<>();
    */
}
