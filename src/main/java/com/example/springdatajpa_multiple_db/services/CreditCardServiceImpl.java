package com.example.springdatajpa_multiple_db.services;

import com.example.springdatajpa_multiple_db.domain.cardholder.CreditCardHolder;
import com.example.springdatajpa_multiple_db.domain.creditcard.CreditCard;
import com.example.springdatajpa_multiple_db.domain.pan.CreditCardPAN;
import com.example.springdatajpa_multiple_db.repositories.cardholder.CreditCardHolderRepository;
import com.example.springdatajpa_multiple_db.repositories.creditcard.CreditCardRepository;
import com.example.springdatajpa_multiple_db.repositories.pan.CreditCardPANRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService{

    private final CreditCardRepository creditCardRepository;
    private final CreditCardHolderRepository creditCardHolderRepository;
    private final CreditCardPANRepository creditCardPANRepository;

    @Override
    public CreditCard getCreditCardById(Long id) {
        // todo impl
        return null;
    }

    @Transactional
    @Override
    public CreditCard saveCreditCard(CreditCard cc) {
        var savedCC = creditCardRepository.save(cc);

        // repopulated the savedCC with info returned from 1 db
        savedCC.setFirstName(cc.getFirstName());
        savedCC.setLastName(cc.getLastName());
        savedCC.setZipCode(cc.getZipCode());
        savedCC.setCreditCardNumber(cc.getCreditCardNumber());

        // update the info on other 2 db
        creditCardHolderRepository.save(CreditCardHolder.builder()
                        .creditCardId(savedCC.getId())
                        .firstName(savedCC.getFirstName())
                        .lastName(savedCC.getLastName())
                        .zipCode(savedCC.getZipCode())
                .build());

        creditCardPANRepository.save(CreditCardPAN.builder()
                        .creditCardNumber(savedCC.getCreditCardNumber())
                        .creditCardId(savedCC.getId())
                .build());

        return savedCC;
    }
}


















