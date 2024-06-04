package com.example.practice15;

import com.example.practice15.models.Bank;
import com.example.practice15.services.BankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.practice15.repositories.BankRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BankServiceTest {
    @Mock
    private BankRepository bankRepository;

    @Captor
    ArgumentCaptor<Bank> captor;

    @Test
    void getAllBanks() {
        Bank bank = new Bank();
        bank.setName("bank1");
        Bank bank2 = new Bank();
        bank2.setName("bank2");


        Mockito.when(bankRepository.getAllBy()).thenReturn(Optional.of(List.of(bank, bank2)));
        BankService bankService = new BankService(bankRepository, bankRepository);

        assertEquals(2, bankService.getAllBanks().size());
        assertEquals("bank1", bankService.getAllBanks().get(0).getName());
    }

    @Test
    void addBank() {
        Bank bank = new Bank();
        bank.setName("bank");

        BankService bankService = new BankService(bankRepository, bankRepository);
        bankService.addBank(bank);

        Mockito.verify(bankRepository).save(captor.capture());
        Bank captured = captor.getValue();

        assertEquals("bank", captured.getName());
    }
}
