package com.MahentaRestApp.Mahenta.Movie;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    public long id;
    public String Title;
    public String Description;
    public int Year;
}
