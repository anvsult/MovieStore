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

public class DirectorResponseDTO {
    private String directorId;
    private String name;
    private LocalDate dob;
    private String country;
    private String imageURL;
}
