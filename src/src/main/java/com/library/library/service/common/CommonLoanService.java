package com.library.library.service.common;

import com.library.library.controller.dto.LoanResponseDto;
import com.library.library.model.Book;
import com.library.library.model.Loan;
import com.library.library.model.Member;
import com.library.library.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonLoanService implements CommonService<Loan>{

    private final LoanRepository repository;

    @Override
    public List<Loan> findAll() {
        return repository.findAll();
    }

    @Override
    public Loan findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find loan!"));
    }

    public Loan create(Loan loan) {
        return repository.save(loan);
    }

    public Loan update(Loan obj) {
        obj.setLastUpdateDate(OffsetDateTime.now());
        return repository.save(obj);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Loan> findByBorrower(Member member) {
        return repository.findByBorrowedBy(member);
    }

    public Loan findByBook(Book book) {
        return repository.findByBook(book);
    }

    public Loan findByBookId(int id) {
        return repository.findByBookId(id);
    }
}
