package com.library.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class ObjectModel {

    @Column(nullable = false, updatable = false)
    protected OffsetDateTime createdDate;

    @Column(nullable = false)
    protected OffsetDateTime lastUpdateDate;
}
