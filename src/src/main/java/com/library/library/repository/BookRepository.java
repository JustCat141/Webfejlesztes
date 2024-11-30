package com.library.library.repository;

import com.library.library.model.Book;
import com.library.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

}
