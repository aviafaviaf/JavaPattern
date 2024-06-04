package com.example.practice15.repositories;

import com.example.practice15.models.Card;

import java.util.List;

public interface CardRepositoryCustom {
    List<Card> findCardsByCriteria(String cardName, String code, Long bankId);
}
