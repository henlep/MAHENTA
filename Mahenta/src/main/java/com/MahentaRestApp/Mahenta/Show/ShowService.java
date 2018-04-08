package com.MahentaRestApp.Mahenta.Show;

import org.springframework.stereotype.Service;

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
}