package com.MahentaRestApp.Mahenta.Movie;



import com.MahentaRestApp.Mahenta.Session.Session;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    public long id;
    public String Title;
    public String Description;
    public int Year;


    
}
