package com.library.library.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.library.model.Book;
import com.library.library.model.User;
import com.library.library.repository.BookRepository;
import com.library.library.repository.UserRepository;
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
    private final UserRepository userRepository; // UserRepository for loading users

    @Value("classpath:data/books.json")
    private Resource bookResource;

    @Value("classpath:data/users.json") // Add the users.json resource
    private Resource userResource;

    @PostConstruct
    public void loadData() {
        var objectMapper = new ObjectMapper();

        var bookType = new TypeReference<List<Book>>() {};
        var userType = new TypeReference<List<User>>() {}; // Define user type reference

        try {
            // Load Books
            var booksJson = StreamUtils.copyToString(bookResource.getInputStream(), StandardCharsets.UTF_8);
            var books = objectMapper.readValue(booksJson, bookType);
            bookRepository.saveAll(books); // Save books to the repository

            // Load Users
            var usersJson = StreamUtils.copyToString(userResource.getInputStream(), StandardCharsets.UTF_8);
            var users = objectMapper.readValue(usersJson, userType);
            userRepository.saveAll(users); // Save users to the repository

        } catch (IOException e) {
            log.error("Cannot load data.", e);
        }
    }
}
