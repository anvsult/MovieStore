package com.example.moviestore.presentationLayer;

import com.example.moviestore.dataAccessLayer.Movie;
import com.example.moviestore.serviceLayer.MovieService;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add-movies")
    public List<MovieResponseDTO> addMovies(@RequestBody List<MovieRequestDTO> newMoviesData) {
        return movieService.addMovies(newMoviesData);
    }
    @PostMapping("/add-movie")
    public MovieResponseDTO addMovie(@RequestBody MovieRequestDTO newMovieData) {
        return movieService.addMovie(newMovieData);
    }
    @GetMapping("/get-movies")
    public List<MovieResponseDTO> getMovies() {
        return movieService.getMovies();
    }
    @GetMapping("/get-movie/{movieId}")
    public MovieResponseDTO getMovieById(@PathVariable String movieId) {
        return movieService.getMovieById(movieId);
    }
    @PutMapping("/update-movie/{movieId}")
    public MovieResponseDTO updateMovie(@PathVariable String movieId, @RequestBody MovieRequestDTO updatedMovieData) {
        return movieService.updateMovie(movieId, updatedMovieData);
    }
    @DeleteMapping("/delete-movie/{movieId}")
    public String deleteMovie(String movieId) {
        return movieService.deleteMovie(movieId);
    }
}
