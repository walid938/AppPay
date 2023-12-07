package com.payMyBuddy.AppPay.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payMyBuddy.AppPay.model.ApplicationUser;
import com.payMyBuddy.AppPay.model.Transaction;
import com.payMyBuddy.AppPay.repository.TransactionRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionFeeService transactionFeeService;

    public List<Transaction> getTransactionsByUser(ApplicationUser user) {
        return transactionRepository.findBySenderIdOrRecipientId(user.getId(), user.getId());
    }

    public Transaction createTransaction(ApplicationUser sender, ApplicationUser recipient, BigDecimal amount) {
        // Logique de validation et création d'une nouvelle transaction entre l'expéditeur et le destinataire
        // ...

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setRecipient(recipient);
        transaction.setAmount(amount);

        Transaction savedTransaction = transactionRepository.save(transaction);

        // Ajout d'un frais de transaction
        BigDecimal transactionFeeAmount = calculateTransactionFee(amount);
        transactionFeeService.addTransactionFee(savedTransaction, transactionFeeAmount);

        return savedTransaction;
    }

    private BigDecimal calculateTransactionFee(BigDecimal transactionAmount) {
        // Logique de calcul des frais de transaction (0.5% dans cet exemple)
        return transactionAmount.multiply(BigDecimal.valueOf(0.005));
    }

    // Ajoutez d'autres méthodes liées à la logique métier des transactions
}

