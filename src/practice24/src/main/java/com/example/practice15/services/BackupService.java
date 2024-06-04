package com.example.practice15.services;

import com.example.practice15.dto.BankDto;
import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BackupService {

    private final BankService bankService;

    private final CardService cardService;

    @Scheduled(fixedRate = 300000)
    @Async
    public void backup() {
        cleanBackupFolder();
        backupBanks();
        backupCards();
        log.info("Backup complete");
    }

    private static void cleanBackupFolder() {
        File folder = new File("src/main/resources/backup");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (!f.delete()) {
                    log.error("Failed to delete file {}", f);
                }
            }
        }
    }

    private void backupBanks() {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/backup/bank.txt", StandardCharsets.UTF_8);
            writer.print("");
            List<BankDto> banks = bankService.getAllBanks().stream().map(Bank::toDto).toList();
            for (BankDto bank : banks) {
                writer.append(bank.toString()).append("\n");
            }
            writer.close();
            log.info("Banks backup complete");
        } catch (Exception e) {
            log.error("Failed to backup banks", e);
        }
    }

    private void backupCards() {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/backup/card.txt", StandardCharsets.UTF_8);
            writer.print("");
            List<Card> cards = cardService.getAllCards();
            for (Card card : cards) {
                writer.append(card.toDto().toString()).append("\n");
            }
            writer.close();
            log.info("Cards backup complete");
        } catch (Exception e) {
            log.error("Failed to backup cards", e);
        }
    }
}
