package com.MahentaRestApp.Mahenta;

import com.MahentaRestApp.Mahenta.Session.Session;
import com.MahentaRestApp.Mahenta.Session.SessionRepository;
import com.MahentaRestApp.Mahenta.Session.SessionService;
import com.MahentaRestApp.Mahenta.Show.Show;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionTests {
    @Mock
    private SessionRepository sessionRepository;
    Session session = new Session();
    @Test
    public void SessionTest() {
        List<Session> sessionList = new ArrayList<>();


        Session firstSession = new Session();
        firstSession.Cinema = "Forum";
        firstSession.CinemaHall = "3D";
        firstSession.FreeSeats = 24;
        firstSession.Date = LocalDate.now();
        firstSession.movie_id = 1;
        firstSession.id = 2;
        sessionList.add(firstSession);

        SessionRepository repository = mock(SessionRepository.class);
        SessionService service = new SessionService(repository);
        when(repository.findAll(any())).thenReturn(sessionList);
    }
    @Before
    public void setUp() {
        session.id=1;
        session.Date= LocalDate.now();
        session.FreeSeats = 55;
        session.Cinema = "plaza";
        session.movie_id = 1;
        session.id=4;
    }

        @Test

        public void addSession() {

            Assert.assertEquals(session, sessionRepository.save(session));

    }
    @Test
    public void getSessionsTest() {
        Assert.assertEquals(session, sessionRepository.findAll());
    }
    
}
