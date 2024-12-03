package com.library.library.service;

import com.library.library.model.Book;
import com.library.library.model.Loan;
import com.library.library.service.common.CommonBookService;
import com.library.library.service.common.CommonLoanService;
import com.library.library.service.common.CommonMemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private CommonLoanService loanService;
    private CommonBookService bookService;
    private CommonMemberService memberService;

    public void returnBook(Book book) {
        Loan activeLoan = loanService.findByBook(book);

        loanService.delete(activeLoan);
    }

}
