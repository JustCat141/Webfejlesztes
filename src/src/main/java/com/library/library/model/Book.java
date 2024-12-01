package com.library.library.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BOOKS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book extends ObjectModel {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer publicationYear;

    @ManyToOne
    private Loan loans;
}
