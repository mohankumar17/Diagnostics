package com.spring.backend.labservice.VO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@Entity
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

    public Address(int i, String s, String mountain_view_california, int i1, String s1) {
    }
}

