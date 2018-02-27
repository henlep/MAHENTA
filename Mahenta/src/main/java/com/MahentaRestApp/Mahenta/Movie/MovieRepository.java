package com.MahentaRestApp.Mahenta.Movie;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    List<Movie> getAllMovies(){
        List<Movie> list = new ArrayList<Movie>();

        Movie x = new Movie();
        x.Title = "Pealkiri1";
        x.Description="Kirjeldus1";
        x.Year = 1;
        list.add(x);

        Movie y = new Movie();
        y.Title = "Pealkiri2";
        y.Description="Kirjeldus2";
        y.Year = 2;
        list.add(y);

        Movie z = new Movie();
        z.Title = "Pealkiri3";
        z.Description="Kirjeldus3";
        z.Year = 3;
        list.add(z);


        return list;
    }
}
