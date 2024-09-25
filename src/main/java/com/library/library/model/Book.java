package com.library.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKS")
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private Integer releaseYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User borrowedBy;

    public boolean isBorrowed() {
        return borrowedBy != null;
    }
}
