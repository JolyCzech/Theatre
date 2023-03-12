package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

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

    @NotNull
    @Size(min = 3, max = 30, message = "Имя должно быть длиннее 3 символов")
    private String name;

    @NotNull
    @Range(min = 10, message = "число мест должно быть больше 10")
    private int countPlace;

    @ManyToOne
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private Theatre theatre;

    @OneToMany(mappedBy = "hall")
    private List<Seance> seances;


}
