package com.example.semesterprojektbackend.security;

import com.example.semesterprojektbackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
