package com.library.library.controller;

import com.library.library.controller.dto.LoanRequestDto;
import com.library.library.controller.dto.LoanResponseDto;
import com.library.library.model.Loan;
import com.library.library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoanController {

    private final LoanService service;

    @GetMapping("loans")
    public List<LoanResponseDto> findAll() {
        return service.findAll()
                .stream()
                .map(LoanResponseDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("loan/{id}")
    public LoanResponseDto findById(@PathVariable int id) {
        return LoanResponseDto.of(service.findById(id));
    }

    @PostMapping("loan/loan-book")
    public void create(@RequestBody LoanRequestDto loan) {
        service.create(loan.getMemberId(), loan.getBookId());
    }
}
