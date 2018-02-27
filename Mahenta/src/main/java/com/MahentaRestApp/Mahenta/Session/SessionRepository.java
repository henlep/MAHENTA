package com.MahentaRestApp.Mahenta.Session;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SessionRepository {
    List<Session> getAllSessions(){
        List<Sessions> list = new ArrayList<Sessions>();

        Session x = new Session();
        x.MovieTitle = "Pealkiri1";
        x.CinemaHall="saal a";
        x.Cinema="Viimsi kino";
        x.FreeSeats = 1;
        list.add(x);

        Session x = new Session();
        y.MovieTitle = "Pealkiri2";
        y.CinemaHall="saal b";
        y.Cinema="Mustamae kino";
        y.FreeSeats = 21;
        list.add(y);

        Movie z = new Movie();
        z.MovieTitle = "Pealkiri3";
        z.CinemaHall="suur saal";
        z.Cinema="Solaris kino"
        z.FreeSeats = 31;
        list.add(z);


        return list;
    }
}
