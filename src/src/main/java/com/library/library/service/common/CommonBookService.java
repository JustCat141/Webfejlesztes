package com.library.library.service.common;

import com.library.library.model.Book;
import com.library.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonBookService implements CommonService<Book> {

    private final BookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find library book!"));
    }

    public void create(String title, String author, int publicationYear) {
        Book book = Book.builder()
                .title(title)
                .author(author)
                .publicationYear(publicationYear)
                .loans(new HashSet<>())
                .createdDate(OffsetDateTime.now())
                .lastUpdateDate(OffsetDateTime.now())
                .build();

        repository.save(book);
    }

    @Override
    public Book update(Book obj) {
        obj.setLastUpdateDate(OffsetDateTime.now());
        return repository.save(obj);
    }

    @Override
    public void delete(Book obj) {
        repository.deleteById(obj.getId());
    }
}
