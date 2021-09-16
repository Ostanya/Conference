package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.service.impl.EventService;
import com.epam.rd.java.finalconf.service.impl.TopicService;

import javax.servlet.http.HttpServletRequest;

public class ModeratorEditEvent implements Command {
    public ModeratorEditEvent(EventService eventService, TopicService topicService) {
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
