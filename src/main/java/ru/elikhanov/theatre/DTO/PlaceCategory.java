package ru.elikhanov.theatre.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PlaceCategory {

    @Size(min = 3, max = 30, message = "Name should longer than 2 and shorter than 30")
    private String name;

}