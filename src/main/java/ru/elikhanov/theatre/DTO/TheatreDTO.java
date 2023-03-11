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
public class TheatreDTO {
    @NotNull
    private CityDTO city;
    @NotNull
    private String address;
    @NotNull
    private String description;
    @NotNull
    private String website;
    @NotNull
    private String phoneNumber;

}
