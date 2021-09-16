package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.service.impl.EventService;

import javax.servlet.http.HttpServletRequest;

public class ModeratorDeleteEvent implements Command {
    public ModeratorDeleteEvent(EventService eventService) {
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
