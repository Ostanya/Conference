package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.service.impl.EventService;

import javax.servlet.http.HttpServletRequest;

import static com.epam.rd.java.finalconf.util.Resolver.resolve;

public class Index implements Command {
    private final EventService eventService;

    public Index(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("events",  eventService.getAllEvents());
        return resolve("index");
    }
}
