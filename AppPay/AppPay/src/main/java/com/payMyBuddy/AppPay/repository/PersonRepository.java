package com.payMyBuddy.AppPay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payMyBuddy.AppPay.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByUserId(Long userId);

    
}
