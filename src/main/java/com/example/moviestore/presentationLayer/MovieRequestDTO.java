package com.example.moviestore.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class MovieRequestDTO {
    private String movieId;
    private String title;
    private String directorId;
    private Integer releaseYear;
    private String posterURL;
}
