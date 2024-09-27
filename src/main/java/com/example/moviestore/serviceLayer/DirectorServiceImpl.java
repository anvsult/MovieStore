package com.example.moviestore.serviceLayer;

import com.example.moviestore.dataAccessLayer.Director;
import com.example.moviestore.dataAccessLayer.Movie;
import com.example.moviestore.dataMapperLayer.DirectorResponseMapper;
import com.example.moviestore.presentationLayer.DirectorRequestDTO;
import com.example.moviestore.presentationLayer.DirectorResponseDTO;
import org.springframework.beans.BeanUtils;
import com.example.moviestore.dataAccessLayer.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService{
    private final DirectorRepository directorRepository;
    private final DirectorResponseMapper directorResponseMapper;
    private final MovieService movieService;

    @Autowired
    public DirectorServiceImpl(DirectorRepository directorRepository, DirectorResponseMapper directorResponseMapper, MovieService movieService){
        this.directorRepository = directorRepository;
        this.directorResponseMapper = directorResponseMapper;
        this.movieService = movieService;
    }

    @Override
    public DirectorResponseDTO addDirector(DirectorRequestDTO directorRequestDTO){
        if (directorRequestDTO == null){
            return null;
        } else if (directorRepository.findDirectorByDirectorId(directorRequestDTO.getDirectorId()) != null){
            return null;
        }
        Director director = new Director();
        BeanUtils.copyProperties(directorRequestDTO, director);
        director.setDirectorId(directorRequestDTO.getDirectorId());
        System.out.println(
                director.getId() + " " +
                director.getDirectorId() + " " +
                director.getName() + " " +
                director.getDob() + " " +
                director.getCountry() + " " +
                director.getImageURL());
        //save director entity to database via repository
        this.directorRepository.save(director);
        return directorResponseMapper.entityToResponseDTO(director);
    }

    @Override
    public List<DirectorResponseDTO> addDirectors(List<DirectorRequestDTO> directorRequestDTOs){
        List<Director> directors = new ArrayList<>();
        for (DirectorRequestDTO d : directorRequestDTOs){
            Director director = new Director();
            //convert directoRequestDTO to an Entity
            BeanUtils.copyProperties(d, director);
            director.setDirectorId(d.getDirectorId());
            System.out.println(
                    director.getId() + " " +
                    director.getDirectorId() + " " +
                    director.getName() + " " +
                    director.getDob() + " " +
                    director.getCountry() + " " +
                    director.getImageURL());
            //save director entity to database via repository
            this.directorRepository.save(director);
            directors.add(director);
        }
        return directorResponseMapper.entityListToResponseDTOList(directors);
    }

    @Override
    public List<DirectorResponseDTO> getDirectors() {
        List<Director> directors = this.directorRepository.findAll();
        return directorResponseMapper.entityListToResponseDTOList(directors);
    }

    @Override
    public DirectorResponseDTO getDirectorById(String directorId) {
        Director director = this.directorRepository.findDirectorByDirectorId(directorId);
        return directorResponseMapper.entityToResponseDTO(director);
    }

    @Override
    public DirectorResponseDTO updateDirector(String directorId, DirectorRequestDTO updatedDirectorData) {
        Director director = this.directorRepository.findDirectorByDirectorId(directorId);
        if (director == null){
            return null;
        }
        BeanUtils.copyProperties(updatedDirectorData, director);
        director.setDirectorId(directorId);
        this.directorRepository.save(director);
        return directorResponseMapper.entityToResponseDTO(director);
    }

    @Override
    public String deleteDirector(String directorId) {
        String message = "";
        Director director = this.directorRepository.findDirectorByDirectorId(directorId);
        if (director == null){
            message = "Director with id: " + directorId + " not found in repository.";
        } else {
            for (Movie m : director.getMovies()){
                movieService.deleteMovie(m.getMovieId());
            }
            this.directorRepository.delete(director);
            message = "Director with id: " + directorId + " deleted successfully.";
        }
        return message;
    }


}
