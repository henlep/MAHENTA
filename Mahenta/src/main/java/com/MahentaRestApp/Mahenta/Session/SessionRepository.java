package com.MahentaRestApp.Mahenta.Session;

import com.MahentaRestApp.Mahenta.Movie.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    @Override
    public List<Session> findAll();
}
