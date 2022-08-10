 package com.spring.backend.labservice.VO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@Table(name = "card")
@Entity
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
}