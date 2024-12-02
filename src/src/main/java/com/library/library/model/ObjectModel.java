package com.library.library.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectModel {

    protected OffsetDateTime createdDate;
    protected OffsetDateTime lastUpdateDate;
}
