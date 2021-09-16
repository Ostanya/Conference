package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.service.impl.EventService;
import com.epam.rd.java.finalconf.service.impl.ParticipantService;
import com.epam.rd.java.finalconf.service.impl.ServiceSecurity;

import javax.servlet.http.HttpServletRequest;

public class SpeakerEvents implements Command {
    public SpeakerEvents(ServiceSecurity securityService, EventService eventService, ParticipantService participantService) {
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
