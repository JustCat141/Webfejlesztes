package com.library.library.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@With
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOK_LOANS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Loan extends ObjectModel{
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @ManyToOne
    private Member borrowedBy;

    @ManyToOne
    private Book book;

    @Column(nullable = false)
    private OffsetDateTime loanDate;

    @Column(nullable = false)
    private OffsetDateTime returnDueDate;
}
