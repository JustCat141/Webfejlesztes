package com.library.library.controller.dto;

import com.library.library.model.Book;
import com.library.library.model.Loan;
import com.library.library.model.Member;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class LoanResponseDto {
    int id;
    MemberDto memberId;
    BookDto book;
    OffsetDateTime loanDate;
    OffsetDateTime returnDueDate;

    OffsetDateTime createdDate;
    OffsetDateTime lastUpdateDate;

    public static LoanResponseDto of(Loan loan) {
        return LoanResponseDto.builder()
                .id(loan.getId())
                .memberId(MemberDto.of(loan.getBorrowedBy()))
                .book(BookDto.of(loan.getBook()))
                .loanDate(loan.getLoanDate())
                .returnDueDate(loan.getReturnDueDate())
                .createdDate(loan.getCreatedDate())
                .lastUpdateDate(loan.getLastUpdateDate())
                .build();
    }
}
