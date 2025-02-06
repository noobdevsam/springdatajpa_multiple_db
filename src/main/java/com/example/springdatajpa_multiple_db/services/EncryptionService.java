package com.example.springdatajpa_multiple_db.services;

public interface EncryptionService {

    String encrypt(String freeText);

    String decrypt(String encryptedText);
}
