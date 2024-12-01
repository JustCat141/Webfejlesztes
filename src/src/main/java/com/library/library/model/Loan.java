package com.library.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;


@Entity
@Table(name = "BOOK_LOANS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Loan extends ObjectModel{
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @ManyToOne
    private Member borrowedBy;

    @OneToOne
    private Book book;

    @Column(nullable = false)
    private OffsetDateTime loanDate;

    @Column(nullable = false)
    private OffsetDateTime returnDueDate;

    private OffsetDateTime returnDate;
}
