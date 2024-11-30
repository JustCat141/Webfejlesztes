package com.library.library.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@With
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private String author;
    private Integer releaseYear;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private BookLoan borrowedBy; // Link to BookLoan

    public boolean isBorrowed() {
        return borrowedBy != null;
    }
}
