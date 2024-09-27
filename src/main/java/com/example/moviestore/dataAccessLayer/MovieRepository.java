package com.example.moviestore.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByMovieId(String movieId);
}
