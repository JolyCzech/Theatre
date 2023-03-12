package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "performance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 30, message = "Name should longer than 2 and shorter than 100")
    private String title;

    @Size(max = 3000, message = "Description should be shorter than 3500")
    private String description;

    @Size(min = 3, max = 30, message = "Director's name should longer than 2 and shorter than 100")
    private String director;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    private int age;

    @OneToMany(mappedBy = "performance")
    private List<Seance> seances;


}
