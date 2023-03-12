package ru.elikhanov.theatre.DTO;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerformanceDTO {

    @Size(min = 3, max = 30, message = "Name should longer than 3 and shorter than 100")
    private String title;

    @Size(max = 3000, message = "Description should be shorter than 3500")
    private String description;

    @Size(min = 3, max = 30, message = "Director's name should longer than 3 and shorter than 100")
    private String director;

    private int age;

    private GenreDTO genreDTO;

    private CategoryDTO category;
}
