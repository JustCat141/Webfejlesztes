package com.library.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@With
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USERS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Member extends ObjectModel {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    private OffsetDateTime birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "borrowedBy")
    private Set<Loan> loans;
}
