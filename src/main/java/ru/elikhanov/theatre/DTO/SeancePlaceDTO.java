package ru.elikhanov.theatre.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeancePlaceDTO {

    @NotNull
    private PlaceDTO place;
    @NotNull
    private SeanceDTO seance;
    @NotNull
    private boolean reserved;

    private ClientDTO client;

}
