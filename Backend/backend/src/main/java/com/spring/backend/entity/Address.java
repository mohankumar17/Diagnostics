package com.spring.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "address", schema = "public")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "house_no")
    private String houseNum;

    @Column(name = "area")
    private String area;

    @Column(name = "zipcode")
    private int zipcode;

    @Column(name = "city_state")
    private String cityState;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments;

    public Address(String houseNum, String area, int zipcode, String cityState) {
        this.houseNum = houseNum;
        this.area = area;
        this.zipcode = zipcode;
        this.cityState = cityState;
    }

    public Address(int id, String houseNum, String area, int zipcode, String cityState) {
        this.id = id;
        this.houseNum = houseNum;
        this.area = area;
        this.zipcode = zipcode;
        this.cityState = cityState;
    }

    public Address(int id, String houseNum, String area, int zipcode, String cityState, User user, List<Appointment> appointments) {
        this.id = id;
        this.houseNum = houseNum;
        this.area = area;
        this.zipcode = zipcode;
        this.cityState = cityState;
        this.user = user;
        this.appointments = appointments;
    }

    public Address(int id, String houseNum, String area, int zipcode, String cityState, User user) {
        this.id = id;
        this.houseNum = houseNum;
        this.area = area;
        this.zipcode = zipcode;
        this.cityState = cityState;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", houseNum='" + houseNum + '\'' +
                ", area='" + area + '\'' +
                ", zipcode=" + zipcode +
                ", cityState='" + cityState + '\'' +
                '}';
    }

    public void add(Appointment appointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        }
        appointments.add(appointment);
        appointment.setAddress(this);
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
