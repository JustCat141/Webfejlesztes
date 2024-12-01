package com.library.library.model;

import lombok.*;

import java.time.OffsetDateTime;

@Data
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectModel {

    protected OffsetDateTime createdDate;
    protected OffsetDateTime lastUpdateDate;
}
