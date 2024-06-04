package com.example.practice15.services;

import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import com.example.practice15.repositories.BankRepository;
import com.example.practice15.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;

    public List<Bank> getAllBanks() {
        return bankRepository.getAllBy().orElseThrow();
    }

    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }

    public Integer deleteBankById(Long id) {
        return bankRepository.deleteBankById(id).orElseThrow();
    }
}
