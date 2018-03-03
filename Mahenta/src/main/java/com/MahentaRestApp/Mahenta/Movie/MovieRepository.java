package com.MahentaRestApp.Mahenta.Movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    @Override
    public List<Movie> findAll();
}
