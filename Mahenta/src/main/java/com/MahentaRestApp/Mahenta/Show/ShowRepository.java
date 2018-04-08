package com.MahentaRestApp.Mahenta.Show;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface ShowRepository extends CrudRepository<Show, Long> {
    }
