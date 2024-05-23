package com.example.practice14.controllers;

import com.example.practice14.models.Card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cards")
public class CardController {
    private ArrayList<Card> cards = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<Card> getCards() {
        return cards.stream().toList();
    }

    @PostMapping
    @ResponseBody
    public Card addCard(
            @RequestBody String cardName, String code
    ) {
        int lenBefore = cards.size();
        Card card = new Card(cardName, code);
        card.setCardName(cardName);
        cards.add(card);
        if (cards.size() != lenBefore)
            return card;
        else
            return null;
    }

    @DeleteMapping
    @ResponseBody
    public Card deleteCard(
            @RequestBody Card card
    ) {
        int lenBefore = cards.size();
        cards = new ArrayList<>(
                cards.stream()
                        .filter((authorListItem -> !authorListItem.equals(card)))
                        .toList()
        );
        if (cards.size() != lenBefore)
            return card;
        else
            return null;
    }
}
