package com.library.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.library.misc.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String passwordHash;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "borrowedBy", fetch = FetchType.EAGER)
    private Set<Book> borrowedBooks;
}
