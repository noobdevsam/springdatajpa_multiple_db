package com.example.springdatajpa_multiple_db;

import com.example.springdatajpa_multiple_db.domain.creditcard.CreditCard;
import com.example.springdatajpa_multiple_db.services.CreditCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringdatajpaMultipleDbApplicationTests {

	@Autowired
	CreditCardService creditCardService;

	@Test
	void contextLoads() {
	}

	@Test
	void test_save_and_get_credit_card() {
		var cc = CreditCard.builder()
				.firstName("John")
				.lastName("Doe")
				.zipCode("12333")
				.creditCardNumber("12345678")
				.cvv("333")
				.expirationDate("22/26")
				.build();

		var savedCC = creditCardService.saveCreditCard(cc);

		assertThat(savedCC).isNotNull();
		assertThat(savedCC.getId()).isNotNull();
		assertThat(savedCC.getCreditCardNumber()).isNotNull();

		var fetchedCreditCard = creditCardService.getCreditCardById(savedCC.getId());

		assertThat(fetchedCreditCard).isNotNull();
		assertThat(fetchedCreditCard.getId()).isNotNull();
		assertThat(fetchedCreditCard.getCreditCardNumber()).isNotNull();
	}
}
