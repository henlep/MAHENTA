package com.MahentaRestApp.Mahenta.Session;


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

    @RequestMapping(value="/session", method= RequestMethod.GET)
    public List<Session> getAllSessions() {
        List<Session> list = sessionService.getAllSessions();

        return list;
    }

    @RequestMapping(value="/see", method= RequestMethod.GET)
    public String Test() {
        return "Proov";
    }


}
