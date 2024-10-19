package com.example.springdatajpa_multiple_db.domain.creditcard;

import com.example.springdatajpa_multiple_db.domain.converters.CreditCardConverter;
import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CreditCardConverter.class)
    private String cvv;

    @Convert(converter = CreditCardConverter.class)
    private String expirationDate;

}
