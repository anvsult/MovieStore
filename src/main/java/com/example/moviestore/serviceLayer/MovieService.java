package com.example.moviestore.serviceLayer;

import com.example.moviestore.presentationLayer.MovieRequestDTO;
import com.example.moviestore.presentationLayer.MovieResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    String deleteMovie(String movieId);

    List<MovieResponseDTO> addMovies(List<MovieRequestDTO> newMoviesData);

    MovieResponseDTO addMovie(MovieRequestDTO newMovieData);

    List<MovieResponseDTO> getMovies();

    MovieResponseDTO getMovieById(String movieId);

    MovieResponseDTO updateMovie(String movieId, MovieRequestDTO updatedMovieData);
}
