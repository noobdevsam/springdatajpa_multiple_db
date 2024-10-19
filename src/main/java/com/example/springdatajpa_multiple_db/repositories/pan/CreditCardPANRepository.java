package com.example.springdatajpa_multiple_db.repositories.pan;

import com.example.springdatajpa_multiple_db.domain.pan.CreditCardPAN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardPANRepository extends JpaRepository<CreditCardPAN, Long> {
}
