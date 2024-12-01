package com.library.library.service;
/*
import com.library.library.misc.UserRole;
import com.library.library.model.Book;
import com.library.library.model.User;
import com.library.library.repository.BookRepository;
import com.library.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void save(User user) {
        userRepository.save(user);
    }

    public void register(String username, String password, UserRole role) {

        String passwordHash = passwordEncoder.encode(password);

        User newUser = User.builder()
                .username(username)
                .passwordHash(passwordHash)
                .role(role)
                .build();

        save(newUser);
    }

    public boolean validCredentials(String username, String password) {
        return userRepository
                .findByUsernameAndPasswordHash(username,password)
                .isPresent();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long Id) {
        return userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find user with id %d", Id)));
    }
    
    public void updateUser(Long Id, String username, String passwordHash) {
        if (Stream.of(Id,username,passwordHash).allMatch(Objects::isNull)) {
            throw new UnsupportedOperationException("There is nothing to update!");
        }

        User user = findById(Id);

        if (username != null) {
            user.setUsername(username);
        }

        if (passwordHash != null) {
            user.setPasswordHash(passwordHash);
        }

        save(user);
    }

    public void deleteUser(Long Id) {
        User user = findById(Id);
        List<Book> rentedByUser = bookRepository.findAll()
                .stream()
                .filter(book -> book.getBorrowedBy() != null && book.getBorrowedBy().equals(user))
                .toList();

        rentedByUser.forEach(book -> {
            book.setBorrowedBy(null);
            bookRepository.save(book);
        });

        userRepository.delete(user);
    }
}
*/