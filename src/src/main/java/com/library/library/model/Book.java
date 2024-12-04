package com.library.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@With
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Book extends ObjectModel {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private Integer publicationYear;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne(mappedBy = "book")
    private Loan loan;

    public boolean isBorrowed() {
        return loan != null;
    }
}
