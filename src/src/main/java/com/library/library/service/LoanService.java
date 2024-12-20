package com.library.library.service;

import com.library.library.controller.dto.LoanResponseDto;
import com.library.library.model.Book;
import com.library.library.model.Loan;
import com.library.library.model.Member;
import com.library.library.service.common.CommonBookService;
import com.library.library.service.common.CommonLoanService;
import com.library.library.service.common.CommonMemberService;
import lombok.AllArgsConstructor;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoanService {

    private CommonLoanService loanService;
    private CommonBookService bookService;
    private CommonMemberService memberService;

    public List<Loan> findAll() {
        return loanService.findAll();
    }

    public Loan findById(int id) {
        return loanService.findById(id);
    }

    public Loan create(int memberId, int bookId) {
        Member member = memberService.findById(memberId);
        Book book = bookService.findById(bookId);

        if (book.isBorrowed()) {
            throw new RuntimeException("Book is already loaned by someone else!");
        }

        var today = OffsetDateTime.now();
        var returnDate = today.plusMonths(2);

        Loan newLoan = Loan.builder()
                .borrowedBy(member)
                .book(book)
                .loanDate(today)
                .returnDueDate(returnDate)
                .createdDate(today)
                .lastUpdateDate(today)
                .build();

        loanService.create(newLoan);

        return newLoan;
    }

    public List<LoanResponseDto> findAllByMemberId(int id) {
        var member = memberService.findById(id);
        return member.getLoans()
                .stream()
                .map(LoanResponseDto::of)
                .collect(Collectors.toList());
    }

    public LoanResponseDto findByBookId(int id) {
        Book book = bookService.findById(id);

        if (!book.isBorrowed())
            return null;

        return LoanResponseDto.of(book.getLoan());
    }
}
