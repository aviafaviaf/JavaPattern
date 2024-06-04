package com.example.practice15.services;

import com.example.practice15.dto.BankDto;
import com.example.practice15.dto.CardDto;
import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import com.example.practice15.repositories.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CardService {
    private final CardRepository cardRepository;
    private final CardRepository cardRepositoryCustom;
    public List<Card> getAllCards() {
        log.info("get all cards");
        return cardRepository.getAllBy().orElseThrow();
    }

    public void addCard(Card card) {
        log.info("add card");
        cardRepository.save(card);
    }

    public Integer deleteCardById(Long id) {
        log.info("delete card");
        return cardRepository.deleteCardById(id).orElseThrow();
    }

    public List<CardDto> findByFilter(Card card) {
        log.info("Get card by filter");
        return cardRepositoryCustom
                .findCardsByCriteria(
                        card.getCardName(),
                        card.getCode(),
                        card.getBankId()
                )
                .stream()
                .map(Card::toDto)
                .toList();
    }
}
