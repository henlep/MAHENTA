package com.MahentaRestApp.Mahenta.Show;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
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

    public void deleteOldShows(){
        showRepository.deleteByShowDateBefore(LocalDate.now());
    }

    public List<Show> getShowsOnDate(LocalDate date){


        List<Show> shows =  showRepository.findByShowDate(date);
        shows.sort(Comparator.comparing(Show::getShowTime));



        if (date.equals( LocalDate.now())){
            List<Show> notStartedShows = new ArrayList<>();
            for (Show s : shows){
                if (s.showTime.isAfter(LocalTime.now()) ){
                    notStartedShows.add(s);
                }
            }
            shows = notStartedShows;
        }

        return shows;
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