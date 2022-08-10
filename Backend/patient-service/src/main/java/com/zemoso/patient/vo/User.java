package com.zemoso.patient.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="full_name")
    private String name;

    @Column(name="email")
    private String email;
}
