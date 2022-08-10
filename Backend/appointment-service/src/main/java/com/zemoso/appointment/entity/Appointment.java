package com.zemoso.appointment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
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

    @Column(name = "lab_id")
    private int labId;

    @Column(name = "test_id")
    private int testId;

    @Column(name = "address_id")
    private int addressId;

    @Column(name = "user_id")
    private int userId;

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

    public Appointment(String month, String day, int date, int labId, int testId, int addressId, int userId) {
        this.month = month;
        this.day = day;
        this.date = date;
        this.labId = labId;
        this.testId = testId;
        this.addressId = addressId;
        this.userId = userId;
    }
}
