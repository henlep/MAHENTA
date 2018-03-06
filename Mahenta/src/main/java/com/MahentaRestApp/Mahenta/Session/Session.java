package com.MahentaRestApp.Mahenta.Session;


import com.MahentaRestApp.Mahenta.Movie.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Session {
    @Id
    @GeneratedValue
    public long id;


    public String CinemaHall;
    public String Cinema;
    public int FreeSeats;

    @DateTimeFormat(pattern = "yyyy-MM-dd")@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate Date;

    public long movie_id;
    //cinema_id
    //city_id
    //hall_id

}
