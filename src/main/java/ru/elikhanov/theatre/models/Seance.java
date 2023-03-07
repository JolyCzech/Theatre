package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "seance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "performance_id", referencedColumnName = "id")
    private Performance performance;

    private LocalDateTime startedAt;

    @ManyToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private Hall hall;

}
