package com.example.practice15;

import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import com.example.practice15.repositories.BankRepository;
import com.example.practice15.repositories.CardRepository;
import com.example.practice15.services.BankService;
import com.example.practice15.services.CardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {
    @Mock
    private CardRepository cardRepository;

    @Captor
    ArgumentCaptor<Card> captor;

    @Test
    void getAllCards() {
        Card card = new Card();
        card.setCardName("cardName1");
        Card card2 = new Card();
        card2.setCardName("cardName2");


        Mockito.when(cardRepository.getAllBy()).thenReturn(Optional.of(List.of(card, card2)));
        CardService cardService = new CardService(cardRepository, cardRepository);

        assertEquals(2, cardService.getAllCards().size());
        assertEquals("cardName1", cardService.getAllCards().get(0).getCardName());
    }

    @Test
    void addCard() {
        Card card = new Card();
        card.setCardName("card");

        CardService cardService = new CardService(cardRepository, cardRepository);
        cardService.addCard(card);

        Mockito.verify(cardRepository).save(captor.capture());
        Card captured = captor.getValue();

        assertEquals("card", captured.getCardName());
    }
}

