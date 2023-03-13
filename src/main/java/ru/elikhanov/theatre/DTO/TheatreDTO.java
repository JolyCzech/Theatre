package ru.elikhanov.theatre.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    private String cityName;

    @Size(min = 3, max = 30, message = "Name should longer than 3 and shorter than 30")
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    @Size(max = 3000, message = "Description should be shorter than 3500")
    private String description;
    @NotNull
    private String website;
    @NotNull
    @Pattern(regexp="[\\d]{10}")
    private String phoneNumber;

}
