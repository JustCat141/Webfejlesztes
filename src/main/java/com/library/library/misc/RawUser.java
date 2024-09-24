package com.library.library.misc;

import com.library.library.model.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawUser {
    private Long id;
    private String username;
    private String password;
    private UserRole role;
}
