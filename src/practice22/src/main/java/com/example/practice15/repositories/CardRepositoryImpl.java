package com.example.practice15.repositories;

import com.example.practice15.models.Bank;
import com.example.practice15.models.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class CardRepositoryImpl implements CardRepositoryCustom {
    private EntityManager entityManager;


    @Override
    public List<Card> findCardsByCriteria(String cardName, String code, Long bankId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Card> cq = cb.createQuery(Card.class);

        Root<Card> author = cq.from(Card.class);
        List<Predicate> predicates = new ArrayList<>();

        if (cardName != null) {
            predicates.add(cb.equal(author.get("cardName"), cardName));
        }
        if (code != null) {
            predicates.add(cb.equal(author.get("code"), code));
        }
        if (bankId != null) {
            predicates.add(cb.equal(author.get("bankId"), bankId));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }

}
