package com.library.library.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.library.misc.RawUser;
import com.library.library.misc.UserRole;
import com.library.library.model.Book;
import com.library.library.model.User;
import com.library.library.repository.BookRepository;
import com.library.library.repository.UserRepository;
import com.library.library.service.BookService;
import com.library.library.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class InMemoryDatabaseInitializer {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    private final UserService userService;
    private final BookService bookService;

    @Value("classpath:data/books.json")
    private Resource bookResource;

    @Value("classpath:data/users.json") // Add the users.json resource
    private Resource userResource;

    @PostConstruct
    public void loadData() {
        var objectMapper = new ObjectMapper();

        var bookType = new TypeReference<List<Book>>() {};
        var userType = new TypeReference<List<RawUser>>() {}; // Define user type reference

        try {
            // Load Books
            var booksJson = StreamUtils.copyToString(bookResource.getInputStream(), StandardCharsets.UTF_8);
            var books = objectMapper.readValue(booksJson, bookType);
            bookRepository.saveAll(books); // Save books to the repository

            // Load Users
            var usersJson = StreamUtils.copyToString(userResource.getInputStream(), StandardCharsets.UTF_8);
            var rawUsers = objectMapper.readValue(usersJson, userType);

            rawUsers.forEach(rawUser -> userService.register(rawUser.getUsername(),rawUser.getPassword(), rawUser.getRole()));

            // DEV: remove from prod
            bookService.borrowBook(1L,1L);
            bookService.borrowBook(1L,2L);
            bookService.borrowBook(1L,3L);

        } catch (IOException e) {
            log.error("Cannot load data.", e);
        }
    }
}
