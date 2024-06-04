package com.example.practice15.repositories;

import com.example.practice15.models.Bank;

import java.util.List;

public interface BankRepositoryCustom {
    List<Bank> findBanksByCriteria(String name, String address);
}
