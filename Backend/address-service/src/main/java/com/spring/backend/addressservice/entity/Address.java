package com.spring.backend.addressservice.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "user_id")
    private int userId;

    public Address(String houseNum, String area, int zipcode, String cityState, int userId) {
        this.houseNum = houseNum;
        this.area = area;
        this.zipcode = zipcode;
        this.cityState = cityState;
        this.userId = userId;
    }


}
