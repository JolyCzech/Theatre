package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seanceplace")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeancePlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id",referencedColumnName = "id")
    private Place place;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seance_id",referencedColumnName = "id")
    private Seance seance;

    private boolean reserved;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Client client;
}
