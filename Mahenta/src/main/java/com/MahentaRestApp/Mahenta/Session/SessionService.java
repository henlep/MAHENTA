package com.MahentaRestApp.Mahenta.Session;

import com.MahentaRestApp.Mahenta.Movie.Movie;
import com.MahentaRestApp.Mahenta.Movie.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    List<Session> getAllSessions() {

        return sessionRepository.findAll();
    }

    Session addSession(Session session){

        return sessionRepository.save(session);
    }
}
