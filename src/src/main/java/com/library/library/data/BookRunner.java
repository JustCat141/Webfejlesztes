package com.library.library.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.library.model.Book;
import com.library.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@AllArgsConstructor
@Order(1)
public class BookRunner implements CommandLineRunner {

    private final BookRepository repository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        InputStream jsonStream = getClass().getResourceAsStream("/data/books.json");
        if (jsonStream == null) {
            throw new IllegalArgumentException("books.json not found!");
        }

        List<Book> books = objectMapper.readValue(jsonStream, new TypeReference<List<Book>>() {});

        repository.saveAll(books);
    }
}