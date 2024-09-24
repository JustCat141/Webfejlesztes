package com.library.library.repository;

import com.library.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsernameAndPasswordHash(String username, String passwordHash);
}
