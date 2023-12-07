package com.payMyBuddy.AppPay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payMyBuddy.AppPay.model.ApplicationUser;
import com.payMyBuddy.AppPay.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    BankAccount findByUserId(Long userId);
}


