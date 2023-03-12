package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "place_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PlaceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 30, message = "Name should longer than 3 and shorter than 30")
    private String name;

    @OneToMany(mappedBy = "placeCategory")
    private List<Place> placeList;

}