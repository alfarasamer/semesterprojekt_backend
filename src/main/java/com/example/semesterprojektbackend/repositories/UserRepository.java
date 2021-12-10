package com.example.semesterprojektbackend.repositories;

import com.example.semesterprojektbackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
