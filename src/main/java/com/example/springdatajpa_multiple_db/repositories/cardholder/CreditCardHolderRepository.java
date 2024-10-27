package com.example.springdatajpa_multiple_db.repositories.cardholder;

import com.example.springdatajpa_multiple_db.domain.cardholder.CreditCardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardHolderRepository extends JpaRepository<CreditCardHolder, Long> {

    Optional<CreditCardHolder> findByCreditCardId(Long id);
}
