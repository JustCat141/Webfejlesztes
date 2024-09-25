package com.library.library.controller;

import com.library.library.dto.BookDto;
import com.library.library.dto.BorrowBookRequestDto;
import com.library.library.model.Book;
import com.library.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookDto) {
        Book book = bookService.create(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getReleaseYear());
        bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        bookService.updateBook(id, bookDto.getTitle(), bookDto.getAuthor(), bookDto.getReleaseYear());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{bookId}/borrow")
    public ResponseEntity<Void> borrowBook(@PathVariable Long bookId, @RequestBody BorrowBookRequestDto borrowBookRequest) {
        bookService.borrowBook(borrowBookRequest.getUserId(), bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Void> returnBook(@PathVariable Long bookId) {
        bookService.returnBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
