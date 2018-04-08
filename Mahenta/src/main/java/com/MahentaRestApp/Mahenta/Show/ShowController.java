package com.MahentaRestApp.Mahenta.Show;

import com.MahentaRestApp.Mahenta.Utilites.SessionsXMLParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
public class ShowController {

    @Resource
    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }


    //ARa seda järgnevat lisa
    @RequestMapping(value="/updateShows")
    public Show UpdateShows() throws IOException, SAXException, ParserConfigurationException {
        Show show = new Show();
        SessionsXMLParser sessionsXMLParser = new SessionsXMLParser();
        List<Show> shows = sessionsXMLParser.GetItems();
        for (int i = 0; i<shows.size(); i++){
            show = showService.addShow(shows.get(i));
        }
        return shows.get(0);
    }
}