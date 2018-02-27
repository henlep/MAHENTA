package com.MahentaRestApp.Mahenta.Session;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    List<Session> getAllSessions() {

        return sessionRepository.getAllSessions();
    }

}
