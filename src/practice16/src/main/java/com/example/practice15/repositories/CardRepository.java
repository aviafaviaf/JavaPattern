package com.example.practice15.repositories;

import com.example.practice15.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<List<Card>> getAllBy();
    Optional<Integer> deleteCardById(Long id);
}