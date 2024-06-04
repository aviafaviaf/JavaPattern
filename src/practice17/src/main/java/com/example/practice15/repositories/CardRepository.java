package com.example.practice15.repositories;

import com.example.practice15.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long>,
        CardRepositoryCustom,
        JpaSpecificationExecutor<Card> {
    Optional<List<Card>> getAllBy();
    Optional<Integer> deleteCardById(Long id);
}