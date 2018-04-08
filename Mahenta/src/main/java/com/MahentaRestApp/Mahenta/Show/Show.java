package com.MahentaRestApp.Mahenta.Show;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "shows_table")
public class Show {

    @Id
    public long id;
    public String Title;
    public String Cinema;
    public String Hall;
    public LocalDateTime ShowStart;
    public String ImgUrl;

}