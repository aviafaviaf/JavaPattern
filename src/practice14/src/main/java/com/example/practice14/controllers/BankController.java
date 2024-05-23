package com.example.practice14.controllers;

import com.example.practice14.models.Bank;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/banks")
public class BankController {
    private ArrayList<Bank> banks = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<Bank> getBanks() {
        return banks.stream().toList();
    }

    @PostMapping
    @ResponseBody
    public Bank addBank(
            @RequestBody Bank card
    ) {
        int lenBefore = banks.size();
        banks.add(card);
        if (banks.size() != lenBefore)
            return card;
        else
            return null;
    }

    @DeleteMapping
    @ResponseBody
    public Bank deleteCard(
            @RequestBody Bank bank
    ) {
        int lenBefore = banks.size();
        banks = new ArrayList<>(
                banks.stream()
                        .filter((authorListItem -> !authorListItem.equals(bank)))
                        .toList()
        );
        if (banks.size() != lenBefore)
            return bank;
        else
            return null;
    }
}