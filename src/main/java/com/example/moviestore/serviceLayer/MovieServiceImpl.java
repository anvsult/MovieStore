package com.example.moviestore.serviceLayer;

import com.example.moviestore.dataAccessLayer.Director;
import com.example.moviestore.dataAccessLayer.DirectorRepository;
import com.example.moviestore.dataAccessLayer.Movie;
import com.example.moviestore.dataAccessLayer.MovieRepository;
import com.example.moviestore.dataMapperLayer.MovieResponseMapper;
import com.example.moviestore.presentationLayer.MovieRequestDTO;
import com.example.moviestore.presentationLayer.MovieResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieResponseMapper movieResponseMapper;
    private final DirectorRepository directorRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieResponseMapper movieResponseMapper, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.movieResponseMapper = movieResponseMapper;
        this.directorRepository = directorRepository;
    }


    @Override
    public String deleteMovie(String movieId) {
        String message;
        Movie movie = movieRepository.findMovieByMovieId(movieId);
        if (movie != null) {
            movieRepository.delete(movie);
            message = "Movie with id " + movieId + " deleted successfully";
        } else {
            message = "Movie with id " + movieId + " not found";
        }
        return message;
    }

    @Override
    public List<MovieResponseDTO> addMovies(List<MovieRequestDTO> movieRequestDTOs) {
        List<Movie> movies = new ArrayList<>();
        for (MovieRequestDTO m : movieRequestDTOs){
            Director foundDirector = directorRepository.findDirectorByDirectorId(m.getDirectorId());
            Movie movie = new Movie();
            //convert movieRequestDTO to an Entity
            BeanUtils.copyProperties(m, movie);
            movie.setMovieId(m.getMovieId());
            movie.setDirector(foundDirector);
            System.out.println(
                    movie.getId() + " " +
                            movie.getMovieId() + " " +
                            movie.getTitle() + " " +
//                            movie.getDirector().getId() + " " +
                            movie.getReleaseYear() + " " +
                            movie.getPosterURL());
            //save movie entity to database via repository
            this.movieRepository.save(movie);
            movies.add(movie);
        }
        return movieResponseMapper.entityListToResponseDTOList(movies);
    }

    @Override
    public MovieResponseDTO addMovie(MovieRequestDTO newMovieData) {
//        if (newMovieData.getMovieId() == null){
//            return null;
//        } else if (movieRepository.findMovieByMovieId(newMovieData.getMovieId()) != null){
//            return null;
//        }
        Director foundDirector = directorRepository.findDirectorByDirectorId(newMovieData.getDirectorId());
        Movie movie = new Movie();
        BeanUtils.copyProperties(newMovieData, movie);
        movie.setMovieId(newMovieData.getMovieId());
        movie.setDirector(foundDirector);

        System.out.println("====================");
        System.out.println(
                movie.getId() + " " +
                movie.getMovieId() + " " +
                movie.getTitle() + " " +
                movie.getDirector() + " " +
                movie.getReleaseYear() + " " +
                movie.getPosterURL());
        System.out.println("====================");
        this.movieRepository.save(movie);
        return movieResponseMapper.entityToResponseDTO(movie);
    }

    @Override
    public List<MovieResponseDTO> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movieResponseMapper.entityListToResponseDTOList(movies);
    }

    @Override
    public MovieResponseDTO getMovieById(String movieId) {
        Movie movie = movieRepository.findMovieByMovieId(movieId);
        return movieResponseMapper.entityToResponseDTO(movie);
    }

    @Override
    public MovieResponseDTO updateMovie(String movieId, MovieRequestDTO updatedMovieData) {
        Movie movie = this.movieRepository.findMovieByMovieId(movieId);
        if (movie == null){
            return null;
        }
        BeanUtils.copyProperties(updatedMovieData, movie);
        movie.setMovieId(movieId);
        this.movieRepository.save(movie);
        return movieResponseMapper.entityToResponseDTO(movie);
    }
}
