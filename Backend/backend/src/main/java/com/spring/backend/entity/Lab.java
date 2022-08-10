package com.spring.backend.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

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
   private int slots_available;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lab", cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments;

   public Lab(int id, String name, float rating, int slots_available) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.slots_available = slots_available;
    }

    public Lab(String name, float rating, int slots_available) {
        this.name = name;
        this.rating = rating;
        this.slots_available = slots_available;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", slots_available=" + slots_available +
                '}';
    }

    public void add(Appointment appointment){
        if(appointments == null){
            appointments = new ArrayList<>();
        }
        appointments.add(appointment);
        appointment.setLab(this);
    }
}
