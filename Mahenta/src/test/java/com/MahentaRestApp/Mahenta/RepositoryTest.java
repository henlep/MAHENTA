package com.MahentaRestApp.Mahenta;

import com.MahentaRestApp.Mahenta.Movie.Movie;
import com.MahentaRestApp.Mahenta.Movie.MovieRepository;
import com.MahentaRestApp.Mahenta.Show.Show;
import com.MahentaRestApp.Mahenta.Show.ShowRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class RepositoryTest {
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class OrphanManagementTest {

        @Autowired
        private MovieRepository movieRepository;

        @Test

        public void myTest() throws Exception {
            movieRepository.save(new Movie());
        }
    }
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class ManagementTest {

        @Autowired
        private ShowRepository showRepository;

        @Test

        public void myShowRepoTest() throws Exception {
            showRepository.save(new Show());
        }
    }
}
