package com.library.library.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@With
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOK_LOANS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "borrower_id", nullable = false)
    private User borrower;

    @OneToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false, unique = true)
    private Book book; // One loan per book

    @Column(nullable = false)
    private OffsetDateTime loanDate;

    @Column(nullable = false)
    private OffsetDateTime dueDate;
    private OffsetDateTime returnDate;

    public boolean isReturned() {
        return returnDate != null;
    }
}
