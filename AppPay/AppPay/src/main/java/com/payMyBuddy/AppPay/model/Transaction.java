package com.payMyBuddy.AppPay.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "emetteurId", nullable = false)
    private ApplicationUser emetteur;

    @ManyToOne
    @JoinColumn(name = "destinataireId", nullable = false)
    private ApplicationUser destinataire;

    private BigDecimal amount;

    private Date date;

    

}
