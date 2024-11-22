package com.library.library.service;

import com.library.library.model.Book;
import com.library.library.model.User;
import com.library.library.repository.BookRepository;
import com.library.library.repository.UserRepository;
import com.sun.source.tree.LambdaExpressionTree;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find book!"));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(String title, String author, Integer releaseYear) {
        Book book =  Book.builder()
                .title(title)
                .author(author)
                .releaseYear(releaseYear)
                .build();

        LOGGER.debug("Book %s created!", title);

        return book;
    }

    public void updateBook(Long id, String title, String author, Integer releaseYear) {
        Book book = findById(id);
        if (Stream.of(title,author,releaseYear).allMatch(Objects::isNull)) {
            throw new UnsupportedOperationException("There is nothing to update!");
        }

        if (title != null) {
            book.setTitle(title);
        }

        if (author != null) {
            book.setAuthor(author);
        }

        if (releaseYear != null) {
            book.setReleaseYear(releaseYear);
        }

        save(book);
    }

    public void deleteBook(Long id) {
        Book book = findById(id);
        User user = userRepository.findById(book.getId())
                .orElseThrow(() -> new RuntimeException("Cannot find user!"));
        //user.getBookLoans().remove(book);

        bookRepository.delete(book);
    }

    public void borrowBook(Long userId, Long bookId) {
        Book book = findById(bookId);

        if (book.isBorrowed()) {
            throw new RuntimeException("Book is already borrowed by someone!");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Cannot find user!"));

        //user.getBorrowedBooks().add(book);
        //book.setBorrowedBy(user);

        userRepository.save(user);
        save(book);


    }

    public void returnBook(Long id) {
        Book book = findById(id);
        //User user = book.getBorrowedBy();

        //user.getBorrowedBooks().remove(book);
        book.setBorrowedBy(null);

        save(book);
        //userRepository.save(user);
    }
}
