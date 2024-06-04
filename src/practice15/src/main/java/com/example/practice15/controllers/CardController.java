package com.example.practice15.controllers;

import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import com.example.practice15.services.BankService;
import com.example.practice15.services.CardService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/cards")
public class CardController {
    private final CardService service;
    private ArrayList<Card> cards = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<Card> getCards() {
        return service.getAllCards();
    }

    @PostMapping
    @ResponseBody
    public Card addCard(
            @RequestBody Card card
    ) {
        service.addCard(card);
        return card;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteCard(@PathVariable Long id) {
        return "Count:" + service.deleteCardById(id);
    }
}