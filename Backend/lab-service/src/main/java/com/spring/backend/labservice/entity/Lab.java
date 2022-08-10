package com.spring.backend.labservice.entity;


import com.spring.backend.labservice.VO.Appointment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="lab")
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="rating")
    private float rating;

    @Column(name="slots_available")
    private int slotsAvailable;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lab", cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments;

    public Lab(int id, String name, float rating, int slotsAvailable) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.slotsAvailable = slotsAvailable;
    }

    public Lab(String name, float rating, int slotsAvailable) {
        this.name = name;
        this.rating = rating;
        this.slotsAvailable = slotsAvailable;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", slots_available=" + slotsAvailable +
                '}';
    }
}
