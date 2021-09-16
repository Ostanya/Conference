package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.service.impl.TopicService;
import com.epam.rd.java.finalconf.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;

public class ModeratorAssignSpeaker implements Command {
    public ModeratorAssignSpeaker(UserService userService, TopicService topicService) {
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
