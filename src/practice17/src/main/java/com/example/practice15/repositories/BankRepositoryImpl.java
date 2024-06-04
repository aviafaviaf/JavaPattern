package com.example.practice15.repositories;

import com.example.practice15.models.Bank;
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
public class BankRepositoryImpl implements BankRepositoryCustom {
    private EntityManager entityManager;
    

    @Override
    public List<Bank> findBanksByCriteria(String name, String address) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bank> cq = cb.createQuery(Bank.class);

        Root<Bank> bank = cq.from(Bank.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(cb.equal(bank.get("name"), name));
        }
        if (address != null) {
            predicates.add(cb.equal(bank.get("address"), address));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
