package com.example.practice15.controllers;

import com.example.practice15.dto.BankDto;
import com.example.practice15.dto.CardDto;
import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import com.example.practice15.services.BankService;
import com.example.practice15.services.CardService;
import com.example.practice15.services.EmailService;
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
    private final EmailService emailService;

    @GetMapping
    @ResponseBody
    public List<CardDto> getCards() {
        return service.getAllCards().stream().map(Card::toDto).toList();
    }

    @PostMapping
    @ResponseBody
    public Card addCard(
            @RequestBody Card card
    ) {
        service.addCard(card);
        emailService.sendEmail("vlad2004ik04@mail.ru", "card add", "card add: " + card);
        return card;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteCard(@PathVariable Long id) {
        return "Count:" + service.deleteCardById(id);
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<CardDto> getFilter(@RequestBody Card card) {
        return service.findByFilter(card);
    }
}