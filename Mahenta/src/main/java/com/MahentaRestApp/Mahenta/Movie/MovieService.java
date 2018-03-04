package com.MahentaRestApp.Mahenta.Movie;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }


    Movie addMovie(Movie movie) {
        // here you can do some validations etc before saving the user

        return movieRepository.save(movie);
    }

    public Movie getMovieById(long movieId) {
        return movieRepository.findOne(movieId);
    }
}
