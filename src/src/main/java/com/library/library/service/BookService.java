package com.library.library.service;

import com.library.library.controller.dto.BookDto;
import com.library.library.model.Book;
import com.library.library.model.Loan;
import com.library.library.service.common.CommonBookService;
import com.library.library.service.common.CommonLoanService;
import com.library.library.service.common.CommonMemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private CommonLoanService loanService;
    private CommonBookService bookService;
    private CommonMemberService memberService;

    public List<Book> findAll() {
        return bookService.findAll();
    }

    public Book findById(int id) {
        return bookService.findById(id);
    }

    public Book create(BookDto bookDto) {
        return bookService.create(
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear()
        );
    }

    public void returnBook(int id) {
        Loan activeLoan = loanService.findByBookId(id);

        loanService.delete(activeLoan);
    }

}
