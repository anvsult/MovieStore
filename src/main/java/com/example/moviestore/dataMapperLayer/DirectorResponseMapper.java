package com.example.moviestore.dataMapperLayer;

import com.example.moviestore.dataAccessLayer.Director;
import com.example.moviestore.presentationLayer.DirectorResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorResponseMapper {
    DirectorResponseDTO entityToResponseDTO(Director director);
    List<DirectorResponseDTO> entityListToResponseDTOList(List<Director> directors);
}
