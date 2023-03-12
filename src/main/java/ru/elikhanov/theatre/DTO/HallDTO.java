package ru.elikhanov.theatre.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import ru.elikhanov.theatre.models.Theatre;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HallDTO {

    @NotNull
    @Size(min = 3, max = 30, message = "Name should longer than 3 and shorter than 30")

    private String name;

    @NotNull
    @Range(min = 10, message = "value should be more than 10")
    private int countPlace;

}
