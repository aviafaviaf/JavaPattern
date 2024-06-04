package com.example.practice15.controllers;

import com.example.practice15.dto.BankDto;
import com.example.practice15.dto.CardDto;
import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import com.example.practice15.repositories.BankRepository;
import com.example.practice15.services.BankService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/banks")
public class BankController {
    private final BankService service;
    private ArrayList<Bank> banks = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<BankDto> getCards() {
        return service.getAllBanks().stream().map(Bank::toDto).toList();
    }


    @PostMapping
    @ResponseBody
    public Bank addBank(
            @RequestBody Bank bank
    ) {
        service.addBank(bank);
        return bank;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBank(@PathVariable Long id) {
        return "Count:" + service.deleteBankById(id);
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<BankDto> getFilter(@RequestBody Bank bank) {
        return service.findByFilter(bank);
    }
}