package ru.elikhanov.theatre.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TheatreDTO {

    private String address;
    private String description;
    private String website;
    private String phoneNumber;

}
