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

        return movieRepository.getAllMovies();
    }

}
