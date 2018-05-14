package com.MahentaRestApp.Mahenta;

import com.MahentaRestApp.Mahenta.Movie.MovieController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

    public class MovieControllerTests {

        @RunWith(SpringRunner.class)
        @SpringBootTest
        public class ControllerTest {

            @Autowired
            private MovieController controller;

            @Test
            public void contexLoads() throws Exception {
                assertThat(controller).isNotNull();
            }
        }
    }

