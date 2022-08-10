package com.spring.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="test")
@Getter
@Setter
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    public Test(int id, String name, String time, int cost) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", cost=" + cost +
                '}';
    }

    public void add(Appointment appointment){
        if(appointments == null){
            appointments = new ArrayList<>();
        }
        appointments.add(appointment);
        appointment.setTest(this);
    }
}
