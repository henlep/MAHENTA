package com.MahentaRestApp.Mahenta.Session;


import com.MahentaRestApp.Mahenta.Movie.Movie;
import com.MahentaRestApp.Mahenta.Movie.MovieController;
import com.MahentaRestApp.Mahenta.Movie.MovieRepository;
import com.MahentaRestApp.Mahenta.Movie.MovieService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SessionController {

    @Resource
    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping(value="/sessions", method= RequestMethod.GET)
    public List<Session> getAllSessions() {
        List<Session> list = sessionService.getAllSessions();

        return list;
    }

    @RequestMapping(value="/sessions/add", method=RequestMethod.POST,
            consumes = "application/json")
    public Session addSession(@RequestBody Session session, long movie_id) {


        return sessionService.addSession(session);
    }

    @RequestMapping(value = "//{id}", method=RequestMethod.GET)
    public Movie getMovie(@PathVariable("id") long movieId) {
        return movieService.getMovieById(movieId);
    }

}
