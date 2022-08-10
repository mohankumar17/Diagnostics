package com.spring.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "user", targetEntity = Appointment.class)
    private List<Appointment> appointments;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "user", targetEntity = Patient.class)
    private List<Patient> patients;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "user", targetEntity = Address.class)
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "user", targetEntity = Card.class)
    private List<Card> cards;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(int id, String name, String email, List<Appointment> appointments, List<Patient> patients, List<Address> addresses, List<Card> cards) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.appointments = appointments;
        this.patients = patients;
        this.addresses = addresses;
        this.cards = cards;
    }

    public void add(Appointment appointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        } else {
            appointments.add(appointment);
            appointment.setTheUser(this);
        }
    }

    public void add(Patient patient) {
        if (patients == null) {
            patients = new ArrayList<>();
        } else {
            patients.add(patient);
            patient.setTheUser(this);
        }
    }

    public void add(Address address) {
        if (addresses == null) {
            addresses = new ArrayList<>();
        } else {
            addresses.add(address);
            address.setTheUser(this);
        }
    }

    public void add(Card card) {
        if (cards == null) {
            cards = new ArrayList<>();
        } else {
            cards.add(card);
            card.setTheUser(this);
        }
    }
}
