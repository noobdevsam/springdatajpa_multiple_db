package com.example.springdatajpa_multiple_db.domain.pan;

import com.example.springdatajpa_multiple_db.domain.converters.CreditCardConverter;
import jakarta.persistence.*;

@Entity
public class CreditCardPAN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CreditCardConverter.class)
    private String creditCardNumber;

}
