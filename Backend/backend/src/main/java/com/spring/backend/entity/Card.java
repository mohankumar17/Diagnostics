package com.spring.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "is required")
    @Column(name = "card_number")
    private String cardNumber;

    @NotBlank(message = "is required")
    @Column(name = "expiry_date")
    private String expiryDate;

    @NotBlank(message = "is required")
    @Column(name = "cvv")
    private String cvv;

    @NotBlank(message = "is required")
    @Column(name = "card_holder")
    private String cardHolder;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Card() {
    }

    public Card(String cardNumber, String expiryDate, String cvv, String cardHolder) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardHolder = cardHolder;
    }

    public Card(int id, String cardNumber, String expiryDate, String cvv, String cardHolder) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardHolder = cardHolder;
    }

    public Card(int id, String cardNumber, String expiryDate, String cvv, String cardHolder, User user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardHolder = cardHolder;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv='" + cvv + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                '}';
    }

    public void setTheUser(User user) {
        //prevent endless loop
        if (sameAsFormer(user))
            return;
        this.user = user;
    }

    private boolean sameAsFormer(User newUser) {
        return Objects.equals(user, newUser);
    }
}
