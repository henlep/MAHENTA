package com.MahentaRestApp.Mahenta;

import com.MahentaRestApp.Mahenta.Movie.Movie;
import com.MahentaRestApp.Mahenta.Movie.MovieRepository;
import com.MahentaRestApp.Mahenta.Movie.MovieService;
import com.MahentaRestApp.Mahenta.Show.Show;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieTests {
    @Mock
    private MovieRepository movieRepository;
    Movie movie = new Movie();
    @Test
    public void MovieTest() {
        List<Movie> movieList = new ArrayList<>();


        Movie firstMovie = new Movie();
        firstMovie.Description = "blabla";
        firstMovie.id = 1;
        firstMovie.Title = "endex";
        firstMovie.Year=2015;
        movieList.add(firstMovie);

        MovieRepository repository = mock(MovieRepository.class);
        MovieService service = new MovieService(repository);
        when(repository.findAll(any())).thenReturn(movieList);
    }
    @Before
    public void setUp() {
        movie.Description = "blabla211212";
        movie.id = 12;
        movie.Title = "endex123";
        movie.Year=2011;
    }

        @Test

        public void addMovie() {

            Assert.assertEquals(movie, movieRepository.save(movie));

    }
    @Test
    public void getMoviesTest() {
        Assert.assertEquals(movie, movieRepository.findAll());
    }
    
}
