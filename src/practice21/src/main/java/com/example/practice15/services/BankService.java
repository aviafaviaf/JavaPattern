package com.example.practice15.services;

import com.example.practice15.dto.BankDto;
import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import com.example.practice15.repositories.BankRepository;
import com.example.practice15.repositories.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BankService {
    private final BankRepository bankRepository;
    private final BankRepository bankRepositoryCustom;
    public List<Bank> getAllBanks() {
        log.info("Get all banks");
        return bankRepository.getAllBy().orElseThrow();
    }

    public void addBank(Bank bank) {
        log.info("Bank added: " + bank);
        bankRepository.save(bank);
    }

    public Integer deleteBankById(Long id) {
        log.info("Delete bank by id: " + id);
        return bankRepository.deleteBankById(id).orElseThrow();
    }

    public List<BankDto> findByFilter(Bank bank) {
        log.info("Find bank by filter");
        return bankRepositoryCustom
                .findBanksByCriteria(
                        bank.getName(),
                        bank.getAddress()
                )
                .stream()
                .map(Bank::toDto)
                .toList();
    }
}
