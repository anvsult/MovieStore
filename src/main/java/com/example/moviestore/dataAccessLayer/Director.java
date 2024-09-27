package com.example.moviestore.dataAccessLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //private id do not disclose to font-end application
    @Column(name = "directorid")
    private String directorId; //public id - it's a UUID which we will store as
    //a string and which MUST be disclosed to front-end
    private String name;
    private LocalDate dob;
    private String country;
    @Column(name = "imageurl")
    private String imageURL;
    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;

}
