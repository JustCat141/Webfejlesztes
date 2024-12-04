package com.library.library.repository;

import com.library.library.model.Book;
import com.library.library.model.Loan;
import com.library.library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    Loan findByBook(Book book);

    Loan findByBookId(int bookId);

    List<Loan> findByBorrowedBy(Member member);
}
