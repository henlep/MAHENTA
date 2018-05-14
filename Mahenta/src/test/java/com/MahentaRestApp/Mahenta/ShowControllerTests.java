package com.MahentaRestApp.Mahenta;

import static org.assertj.core.api.Assertions.assertThat;

import com.MahentaRestApp.Mahenta.Show.ShowController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class ShowControllerTests {

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class ControllerTest {

        @Autowired
        private ShowController controller;

        @Test
        public void contexLoads() throws Exception {
            assertThat(controller).isNotNull();
        }
    }
}
