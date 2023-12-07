package com.payMyBuddy.AppPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payMyBuddy.AppPay.model.Transaction;
import com.payMyBuddy.AppPay.model.TransactionFee;
import com.payMyBuddy.AppPay.repository.TransactionFeeRepository;

import java.math.BigDecimal;

@Service
public class TransactionFeeService {
    @Autowired
    private TransactionFeeRepository transactionFeeRepository;

    public TransactionFee addTransactionFee(Transaction transaction, BigDecimal feeAmount) {
        // Logique de validation et ajout d'un nouveau frais de transaction associé à la transaction

        TransactionFee transactionFee = new TransactionFee();
        transactionFee.setTransaction(transaction);
        transactionFee.setFeeAmount(feeAmount);

        return transactionFeeRepository.save(transactionFee);
    }

    
}

