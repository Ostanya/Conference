package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.service.impl.EventService;

import javax.servlet.http.HttpServletRequest;

public class ModeratorGetAllEvents implements Command {
    public ModeratorGetAllEvents(EventService eventService) {
        //
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
