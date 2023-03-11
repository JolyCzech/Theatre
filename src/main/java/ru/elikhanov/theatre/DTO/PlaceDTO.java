package ru.elikhanov.theatre.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.elikhanov.theatre.models.Hall;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaceDTO {
    @NotNull
    private int number;
    @NotNull
    private Hall hall;
    @NotNull
    private PlaceCategoryDTO placeCategory;
}
