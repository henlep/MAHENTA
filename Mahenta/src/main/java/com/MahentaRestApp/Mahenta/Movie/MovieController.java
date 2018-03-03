package com.MahentaRestApp.Mahenta.Movie;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MovieController {

    @Resource
    private MovieService movieService;
    public MovieController(MovieService userService) {
        this.movieService = movieService;
    }

    @RequestMapping(value="/movies", method= RequestMethod.GET)
    public List<Movie> getAllMovies() {
        List<Movie> list = movieService.getAllMovies();

        return list;
    }

    @RequestMapping(value="/movies/add", method=RequestMethod.POST,
            consumes = "application/json")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }


}
