package com.library.library.controller;

import com.library.library.controller.dto.BookDto;
import com.library.library.controller.dto.MemberDto;
import com.library.library.model.Book;
import com.library.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class BookController {

    private final BookService service;

    @GetMapping("books")
    public List<BookDto> findAll() {
        return service
                .findAll()
                .stream()
                .map(BookDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("books/available")
    public List<BookDto> findAllAvailable() {
        return service
                .findAll()
                .stream()
                .filter(book -> !book.isBorrowed())
                .map(BookDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("book/{id}")
    public BookDto findById(@PathVariable int id) {
        return BookDto.of(service.findById(id));
    }

    @PutMapping("book/update")
    public BookDto update(@RequestParam BookDto bookDto) {
        return service.update(bookDto);
    }

    @PostMapping("book/create")
    public void create(@RequestBody BookDto bookDto) {
        service.create(bookDto);
    }

    @DeleteMapping("book/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @DeleteMapping("book/return/{id}")
    public void returnBook(@PathVariable int id) {
        service.returnBook(id);
    }
}