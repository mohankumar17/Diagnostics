package com.zemoso.patient.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient", schema = "public")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "relation")
    private String relation;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "user_id")
    private int userId;

    public Patient(String relation, String name, Date dob, String gender, int userId) {
        this.relation = relation;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.userId = userId;
    }
}
