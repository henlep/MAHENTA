package com.MahentaRestApp.Mahenta.Show;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface ShowRepository extends CrudRepository<Show, Long> {
    @Override
    public List<Show> findAll();
    }
