package com.example.springdatajpa_multiple_db.repositories.cardholder;

import com.example.springdatajpa_multiple_db.domain.cardholder.CreditCardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardHolderRepository extends JpaRepository<CreditCardHolder, Long> {
}
