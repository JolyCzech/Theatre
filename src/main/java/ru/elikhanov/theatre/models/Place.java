package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "place")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @ManyToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "place_category_id", referencedColumnName = "id")
    private PlaceCategory placeCategory;

    @OneToMany(mappedBy = "place")
    private List<SeancePlace> seancePlaceList;

}
