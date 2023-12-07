package com.payMyBuddy.AppPay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payMyBuddy.AppPay.model.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySenderIdOrRecipientId(Long senderId, Long recipientId);
    // Ajoutez d'autres méthodes spécifiques au besoin
}
