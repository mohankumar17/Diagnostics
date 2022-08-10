package com.zemoso.card.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "card_holder")
    private String cardHolder;

    @Column(name = "user_id")
    private int userId;


}
