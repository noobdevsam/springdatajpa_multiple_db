package com.example.springdatajpa_multiple_db.repositories.creditcard;

import com.example.springdatajpa_multiple_db.domain.creditcard.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
