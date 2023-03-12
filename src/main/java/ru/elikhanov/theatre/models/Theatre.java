package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "theatre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
    @NotNull
    private String address;
    @NotNull
    @Size(max = 3000, message = "Description should be shorter than 3500")
    private String description;
    @NotNull
    @Pattern(regexp="[\\d]{10}")
    private String phoneNumber;

    @OneToMany(mappedBy = "theatre")
    private List<Hall> hallList;

}
