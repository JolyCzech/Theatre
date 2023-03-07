package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hall")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int countPlace;

    @ManyToOne
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private Theatre theatre;

    @OneToMany(mappedBy = "hall")
    private List<Seance> seances;


}
