package com.example.practice15.models;

import com.example.practice15.dto.CardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id = 0L;
    @Column(name = "cardname")
    private String cardName;
    @Column(name = "code")
    private String code;
    @Column(name = "bank_id")
    private Long bankId;
    @ManyToOne
    @JoinColumn(name="bank_id", insertable = false, updatable = false)
    private Bank bank;

    public CardDto toDto() {
        return new CardDto(id, cardName, code, bank.toDto());
    }
}