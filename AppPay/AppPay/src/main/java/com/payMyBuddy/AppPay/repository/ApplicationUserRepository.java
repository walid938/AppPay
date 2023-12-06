package com.payMyBuddy.AppPay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payMyBuddy.AppPay.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{
	 ApplicationUser findByEmailAndPassword(String email, String password);
	}


