package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.elikhanov.theatre.DTO.PlaceCategoryDTO;

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

    @NotNull
    @Pattern(regexp="[\\d]{10}")
    private int number;

    @ManyToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "place_category_id", referencedColumnName = "id")
    private PlaceCategory placeCategory;

    @OneToMany(mappedBy = "place")
    private List<SeancePlace> seancePlaceList;

    public Place(int number, Hall hall, PlaceCategory placeCategory) {
        this.number = number;
        this.hall = hall;
        this.placeCategory = placeCategory;
    }
}
