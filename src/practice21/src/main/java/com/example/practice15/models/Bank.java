package com.example.practice15.models;

import com.example.practice15.dto.BankDto;
import com.example.practice15.dto.CardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id = 0L;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @OneToMany
    private List<Card> cards = new ArrayList<>();

    public BankDto toDto() {
        return new BankDto(id, name, address);
    }
}
