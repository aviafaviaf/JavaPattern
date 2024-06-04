package com.example.practice15.services;

import com.example.practice15.models.Card;
import com.example.practice15.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.getAllBy().orElseThrow();
    }

    public void addCard(Card card) {
        cardRepository.save(card);
    }

    public Integer deleteCardById(Long id) {
        return cardRepository.deleteCardById(id).orElseThrow();
    }
}