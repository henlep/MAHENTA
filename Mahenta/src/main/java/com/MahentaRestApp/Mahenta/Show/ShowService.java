package com.MahentaRestApp.Mahenta.Show;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    private ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Show addShow(Show show){
        return showRepository.save(show);
    }
    List<Show> getAllShowsFromDb() {
        return showRepository.findAll();
    }

    public List<Show> getShowsOnDate(LocalDate date){
        return showRepository.findByShowDate(date);
    }

    public List<String> getCinemasOnDate(LocalDate date){
        List<Show> shows = showRepository.findByShowDate(date);
        List<String> cinemas = new ArrayList<>();
        for (Show show : shows){
            if (!cinemas.contains(show.Cinema)){
                cinemas.add(show.Cinema);
            }
        }
        return cinemas;
    }
}