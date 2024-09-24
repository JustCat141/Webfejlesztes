package com.library.library.service;

import com.library.library.model.Book;
import com.library.library.repository.BookRepository;
import com.library.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

}
