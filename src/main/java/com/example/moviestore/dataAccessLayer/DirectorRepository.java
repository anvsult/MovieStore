package com.example.moviestore.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
    Director findDirectorByDirectorId(String id);
}
