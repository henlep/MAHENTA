package com.MahentaRestApp.Mahenta.Show;

import com.MahentaRestApp.Mahenta.XMLParser.ShowXmlParser;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
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



    @Scheduled(fixedRate = 20*60*1000)
    public void UpdateShows() throws IOException, SAXException, ParserConfigurationException {
       Show show = new Show();
       ShowXmlParser sessionsXMLParser = new ShowXmlParser();
       List<String> dateStrings = new ArrayList<>();

        DateTimeFormatter todayFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate today = LocalDate.now();

        for (int i = 0; i<7; i++){
            LocalDate date = today.plusDays(i);
            dateStrings.add(date.format(todayFormatter));
        }


        List<String> UrlList = new ArrayList<>();
        for (String s : dateStrings){
            UrlList.add("https://www.forumcinemas.ee/xml/Schedule/?area=1008&dt="+s);
            UrlList.add("https://www.apollokino.ee/xml/Schedule/?area=1004&dt="+s);
        }

        UrlList.add("https://kosmos.cinamonkino.com/xml/");

       List<Show> shows = sessionsXMLParser.GetShowsFromUrls(UrlList);
        for (int i = 0; i<shows.size(); i++){
            show = showService.addShow(shows.get(i));
        }

        System.out.println("showsUpdated");


}}