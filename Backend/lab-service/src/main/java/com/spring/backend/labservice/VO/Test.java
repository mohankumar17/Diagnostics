 package com.spring.backend.labservice.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="time")
    private String time;

    @Column(name="cost")
    private int cost;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments;

    public Test(int i, String covid_rtpcr, String s, int i1) {
    }
}

