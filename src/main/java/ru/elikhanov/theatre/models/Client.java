package ru.elikhanov.theatre.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "city")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "Name should longer than 2")
    private String firstName;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "Name should longer than 2")
    private String lastName;

    @Column(name = "age")
    @Range(min = 14, message = "age may not be empty or less than 14")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    private String phoneNumber;



}
