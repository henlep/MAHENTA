package com.MahentaRestApp.Mahenta.Session;


import com.MahentaRestApp.Mahenta.Movie.Movie;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Session {
    @Id
    @GeneratedValue
    public long id;


    public String CinemaHall;
    public String Cinema;
    public int FreeSeats;

    public long movie_id;
    //cinema_id
    //city_id
    //hall_id

}
