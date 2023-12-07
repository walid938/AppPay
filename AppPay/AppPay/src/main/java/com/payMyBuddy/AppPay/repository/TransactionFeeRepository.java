package com.payMyBuddy.AppPay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payMyBuddy.AppPay.model.Transaction;
import com.payMyBuddy.AppPay.model.TransactionFee;

import java.util.List;

public interface TransactionFeeRepository extends JpaRepository<TransactionFee, Long> {
    List<TransactionFee> findByTransaction(Transaction transaction);
    // Ajoutez d'autres méthodes spécifiques au besoin
}