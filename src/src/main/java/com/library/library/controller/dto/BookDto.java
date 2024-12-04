package com.library.library.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.library.model.Book;
import com.library.library.model.Loan;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.OffsetDateTime;

@Data
@Builder
public class BookDto {
    int id;
    String title;
    String author;
    int publicationYear;

    OffsetDateTime createdDate;
    OffsetDateTime lastUpdateDate;
    public static BookDto of(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publicationYear(book.getPublicationYear())
                .createdDate(book.getCreatedDate())
                .lastUpdateDate(book.getLastUpdateDate())
                .build();
    }
}
