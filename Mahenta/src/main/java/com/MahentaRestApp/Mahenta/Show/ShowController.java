package com.MahentaRestApp.Mahenta.Show;

import com.MahentaRestApp.Mahenta.XMLParser.ShowXmlParser;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowController {

    @Resource
    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }





    //localhost:8080/showsDate?date=2018-04-09
    @RequestMapping(value="/getShowsOnDate", method= RequestMethod.GET)
    public List<Show> getAllShowsFromDbWithDate(@RequestParam(value="date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Show> list = showService.getShowsOnDate(date);
        return list;
    }

    @RequestMapping(value="/getCinemasOnDate", method= RequestMethod.GET)
    public List<String> getAllCinemasWithDate(@RequestParam(value="date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<String> list = showService.getCinemasOnDate(date);
        return list;
    }



    @RequestMapping(value="/updateShows")
       public Show UpdateShows() throws IOException, SAXException, ParserConfigurationException {
       Show show = new Show();
       ShowXmlParser sessionsXMLParser = new ShowXmlParser();
       List<String> datestrings = new ArrayList<>();

        DateTimeFormatter todayFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate today = LocalDate.now();
        String todayString = today.format(todayFormatter);
        datestrings.add(todayString);
        LocalDate DayTwo = today.plusDays(1);
        datestrings.add(DayTwo.format(todayFormatter));
        LocalDate DayThree = today.plusDays(2);
        datestrings.add(DayThree.format(todayFormatter));

        List<String> UrlList = new ArrayList<>();
        for (String s : datestrings){
            UrlList.add("https://www.forumcinemas.ee/xml/Schedule/?area=1008&dt="+s);
            UrlList.add("https://www.apollokino.ee/xml/Schedule/?area=1004&dt="+s);
        }

        UrlList.add("https://kosmos.cinamonkino.com/xml/");

       List<Show> shows = sessionsXMLParser.GetShowsFromUrls(UrlList);
        for (int i = 0; i<shows.size(); i++){
            show = showService.addShow(shows.get(i));
        }
        return shows.get(0);


}}