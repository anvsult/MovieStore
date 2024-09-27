package com.example.moviestore.serviceLayer;

import com.example.moviestore.dataAccessLayer.Director;
import com.example.moviestore.presentationLayer.DirectorRequestDTO;
import com.example.moviestore.presentationLayer.DirectorResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DirectorService {

    DirectorResponseDTO addDirector(DirectorRequestDTO directorRequestDTO);

    List<DirectorResponseDTO> addDirectors(List<DirectorRequestDTO> directorRequestDTOs);

    List<DirectorResponseDTO> getDirectors();

    DirectorResponseDTO getDirectorById(String directorId);

    DirectorResponseDTO updateDirector(String directorId, DirectorRequestDTO updatedDirectorData);

    String deleteDirector(String directorId);
}
