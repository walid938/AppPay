package com.payMyBuddy.AppPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payMyBuddy.AppPay.model.ApplicationUser;
import com.payMyBuddy.AppPay.model.BankAccount;
import com.payMyBuddy.AppPay.repository.BankAccountRepository;

import java.math.BigDecimal;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BigDecimal getBalanceByUser(ApplicationUser user) {
        // Implémentez la logique pour récupérer le solde d'un utilisateur
        BankAccount bankAccount = bankAccountRepository.findByUserId(user.getId());
        return (bankAccount != null) ? bankAccount.getBalance() : BigDecimal.ZERO;
    }

    public BankAccount deposit(ApplicationUser user, BigDecimal amount) {
        // Logique de dépôt d'argent sur le compte de l'utilisateur
        BankAccount bankAccount = bankAccountRepository.findByUserId(user.getId());

        if (bankAccount == null) {
            bankAccount = new BankAccount();
            bankAccount.setUserId(user.getId());
            bankAccount.setBalance(BigDecimal.ZERO);
        }

        bankAccount.setBalance(bankAccount.getBalance().add(amount));
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount withdraw(ApplicationUser user, BigDecimal amount) {
        // Logique de retrait d'argent du compte de l'utilisateur
        BankAccount bankAccount = bankAccountRepository.findByUserId(user.getId());

        if (bankAccount == null) {
            // Gérer le cas où le compte n'existe pas
            return null;
        }

        BigDecimal currentBalance = bankAccount.getBalance();

        if (currentBalance.compareTo(amount) < 0) {
            // Gérer le cas où le solde est insuffisant
            return null;
        }

        bankAccount.setBalance(currentBalance.subtract(amount));
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount transfer(ApplicationUser sender, ApplicationUser recipient, BigDecimal amount) {
        // Logique de transfert d'argent entre deux utilisateurs
        BankAccount senderAccount = bankAccountRepository.findByUserId(sender.getId());
        BankAccount recipientAccount = bankAccountRepository.findByUserId(recipient.getId());

        if (senderAccount == null || recipientAccount == null) {
            // Gérer le cas où l'un des comptes n'existe pas
            return null;
        }

        BigDecimal senderBalance = senderAccount.getBalance();

        if (senderBalance.compareTo(amount) < 0) {
            // Gérer le cas où le solde est insuffisant
            return null;
        }

        // Effectuer le transfert
        senderAccount.setBalance(senderBalance.subtract(amount));
        recipientAccount.setBalance(recipientAccount.getBalance().add(amount));

        bankAccountRepository.save(senderAccount);
        bankAccountRepository.save(recipientAccount);

        return senderAccount;
    }

    // Ajoutez d'autres méthodes liées à la logique métier des comptes bancaires
}

