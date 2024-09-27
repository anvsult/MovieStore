package com.example.moviestore.dataMapperLayer;

import com.example.moviestore.dataAccessLayer.Movie;
import com.example.moviestore.presentationLayer.MovieResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieResponseMapper {
    MovieResponseDTO entityToResponseDTO(Movie movie);
    List<MovieResponseDTO> entityListToResponseDTOList(List<Movie> movies);
}
