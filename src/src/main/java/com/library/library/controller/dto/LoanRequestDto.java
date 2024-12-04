package com.library.library.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class LoanRequestDto {
    int id;
    int memberId;
    int bookId;
    OffsetDateTime loanDate;
    OffsetDateTime returnDueDate;

    OffsetDateTime createdDate;
    OffsetDateTime lastUpdateDate;
}
