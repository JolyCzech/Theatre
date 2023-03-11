package ru.elikhanov.theatre.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeanceDTO {

    @NotNull
    private HallDTO hall;

    @NotNull
    private LocalDateTime startedAt;

    @NotNull
    private PerformanceDTO performance;

}
