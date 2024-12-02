package com.library.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@With
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKS")
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

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "book")
    private Set<Loan> loans;
}
