package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.service.impl.EventService;
import com.epam.rd.java.finalconf.service.impl.ServiceSecurity;

import javax.servlet.http.HttpServletRequest;

public class RegisterToEvent implements Command {
    public RegisterToEvent(EventService eventService, ServiceSecurity securityService) {
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
