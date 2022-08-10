package com.spring.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "patient", schema = "public")
@Getter
@Setter
@NoArgsConstructor
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Patient(int id, String relation, String name, Date dob, String gender) {
        this.id = id;
        this.relation = relation;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public Patient(int id, String relation, String name, Date dob, String gender, User user) {
        this.id = id;
        this.relation = relation;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.user = user;
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
