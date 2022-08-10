package com.spring.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "month")
    private String month;

    @Column(name = "day")
    private String day;

    @Column(name = "date")
    private int date;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "lab_id")
    private Lab lab;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "patient_appointment",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients;

    public Appointment() {
    }

    public Appointment(String month, String day, int date) {
        this.month = month;
        this.day = day;
        this.date = date;
    }

    public Appointment(int id, String month, String day, int date) {
        this.id = id;
        this.month = month;
        this.day = day;
        this.date = date;
    }

    public Appointment(int id, String month, String day, int date, Lab lab, Test test, Address address, User user, List<Patient> patients) {
        this.id = id;
        this.month = month;
        this.day = day;
        this.date = date;
        this.lab = lab;
        this.test = test;
        this.address = address;
        this.user = user;
        this.patients = patients;
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
