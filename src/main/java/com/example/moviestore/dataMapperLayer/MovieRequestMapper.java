package com.example.moviestore.dataMapperLayer;

import com.example.moviestore.dataAccessLayer.Movie;
import com.example.moviestore.presentationLayer.MovieRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieRequestMapper {
    Movie requestDTOToEntity(MovieRequestDTO movieRequestDTO);
    // List<MovieRequestDTO> requestListToEntityList(List<MovieRequestDTO> movieRequestDTOs);


}
