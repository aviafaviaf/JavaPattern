package com.example.practice15.repositories;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practice15.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}