package com.MahentaRestApp.Mahenta.Show;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "shows_table")
public class Show {

    @Id
    public long id;
    public String Title;
    public String Cinema;
    public String Hall;
    public LocalDate showDate;
    public LocalTime showTime;
    public String showTimeString;
    public String ImgUrl;
    public String ShowUrl;

    public LocalTime getShowTime(){
        return showTime;
    }

}