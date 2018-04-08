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
import java.util.List;

@RestController
public class ShowController {

    @Resource
    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @RequestMapping(value="/shows", method= RequestMethod.GET)
    public List<Show> getAllShows() throws IOException, SAXException, ParserConfigurationException {
      ShowXmlParser showXmlParser = new ShowXmlParser();
       List<Show> list = showXmlParser.GetItems();
        return list;
    }
    @RequestMapping(value="/database", method= RequestMethod.GET)
    public List<Show> getAllShowsFromDb() {
        List<Show> list = showService.getAllShowsFromDb();
        return list;
    }


    //localhost:8080/showsDate?date=2018-04-09
    @RequestMapping(value="/showsDate", method= RequestMethod.GET)
    public List<Show> getAllShowsFromDbWithDate(@RequestParam(value="date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Show> list = showService.getShowsOnDate(date);
        return list;
    }

    @RequestMapping(value="/cinemas", method= RequestMethod.GET)
    public List<String> getAllCinemasWithDate(@RequestParam(value="date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<String> list = showService.getCinemasOnDate(date);
        return list;
    }



    @RequestMapping(value="/updateShows")
       public Show UpdateShows() throws IOException, SAXException, ParserConfigurationException {
       Show show = new Show();
       ShowXmlParser sessionsXMLParser = new ShowXmlParser();
       List<Show> shows = sessionsXMLParser.GetItems();
        for (int i = 0; i<shows.size(); i++){
            show = showService.addShow(shows.get(i));
       }
        return shows.get(0);


}}