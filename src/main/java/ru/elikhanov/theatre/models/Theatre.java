package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "theatre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    private String address;
    private String description;
    private String website;
    private String phoneNumber;

    @OneToMany(mappedBy = "theatre")
    private List<Hall> hallList;

}
