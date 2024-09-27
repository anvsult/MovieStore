package com.example.moviestore.dataAccessLayer;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //database id
    @Column(name = "movieid")
    private String movieId; //public id
    private String title;
    @Column(name = "releaseyear")
    private Integer releaseYear;
    @Column(name = "posterurl")
    private String posterURL;
    @ManyToOne
    @JoinColumn(name = "directorid", referencedColumnName = "directorid")
    private Director director;
}
