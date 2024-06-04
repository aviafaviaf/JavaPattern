package com.example.practice15.repositories;

import com.example.practice15.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long>,
        BankRepositoryCustom,
        JpaSpecificationExecutor<Bank> {
    Optional<List<Bank>> getAllBy();
    Optional<Integer> deleteBankById(Long id);
}