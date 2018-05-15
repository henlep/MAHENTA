package com.MahentaRestApp.Mahenta;

import com.MahentaRestApp.Mahenta.Show.Show;
import com.MahentaRestApp.Mahenta.Show.ShowRepository;
import com.MahentaRestApp.Mahenta.Show.ShowService;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowServiceTests {
    @Test
    public void GetShowsOnDateTest(){
        List<Show> showList = new ArrayList<>();
        LocalTime testTime = LocalTime.now();

        Show firstShow = new Show();
        firstShow.showTimeString = "12:00";
        firstShow.showTime = testTime;
        firstShow.ShowUrl = "URL1";
        firstShow.id = 132;
        firstShow.Cinema="Plaza";
        showList.add(firstShow);

        Show secondShow = new Show();
        secondShow.showTimeString = "12:00";
        secondShow.showTime = testTime.minusNanos(1);
        secondShow.ShowUrl = "URL1";
        secondShow.id = 1322;
        secondShow.Cinema="Apollo";
        showList.add(secondShow);

        Show thirdShow = new Show();
        thirdShow.showTimeString="12:00";
        thirdShow.showTime = testTime.plusNanos(1);
        thirdShow.ShowUrl = "URL2";
        thirdShow.id =12312;
        thirdShow.Cinema = "Apollo";
        showList.add(thirdShow);

        ShowRepository repository = mock(ShowRepository.class);
        ShowService service = new ShowService(repository);
        when(repository.findByShowDate(any(LocalDate.class))).thenReturn(showList);


        List<Show> resultList = service.getShowsOnDate(LocalDate.now());

        assertEquals(secondShow.id, resultList.get(0).id);

        for (int i = 0; i<resultList.size()-1; i++ ){
           assertTrue(resultList.get(i).showTime.isBefore(resultList.get(i+1).showTime));
        }
    }



    @Test
    public void GetCinemasOnDateTest(){
        List<Show> showList = new ArrayList<>();
        Show firstShow = new Show();
        firstShow.showTimeString = "12:00";
        firstShow.showTime = LocalTime.now();
        firstShow.ShowUrl = "URL1";
        firstShow.id = 132;
        firstShow.Cinema="Plaza";
        showList.add(firstShow);

        Show secondShow = new Show();
        secondShow.showTimeString = "12:00";
        secondShow.showTime = LocalTime.now();
        secondShow.ShowUrl = "URL1";
        secondShow.id = 1322;
        secondShow.Cinema="Apollo";
        showList.add(secondShow);

        Show thirdShow = new Show();
        thirdShow.showTimeString="12:00";
        thirdShow.showTime = LocalTime.now();
        thirdShow.ShowUrl = "URL2";
        thirdShow.id =12312;
        thirdShow.Cinema = "Apollo";
        showList.add(thirdShow);

        ShowRepository repository = mock(ShowRepository.class);
        ShowService service = new ShowService(repository);
        when(repository.findByShowDate(any(LocalDate.class))).thenReturn(showList);

        List<String> resultList = service.getCinemasOnDate(LocalDate.now());

        assertEquals(2, resultList.size());

        String expected = "Plaza";
        String result = resultList.get(0);
        assertEquals(expected, result);
        expected = "Apollo";
        result = resultList.get(1);
        assertEquals(expected, result);



    }
    @Test
    public void DeleteShowsOnDateTest(){
        List<Show> showList = new ArrayList<>();
        Show firstShow = new Show();
        firstShow.showTimeString = "12:00";
        firstShow.showTime = LocalTime.now();
        firstShow.ShowUrl = "URL1";
        firstShow.id = 132;
        firstShow.Cinema="Plaza";
        showList.add(firstShow);

        ShowRepository repository = mock(ShowRepository.class);
        ShowService service = new ShowService(repository);

        repository.deleteByShowDateBefore(LocalDate.now());
        assertTrue(repository.findAll().isEmpty());




    }
}
