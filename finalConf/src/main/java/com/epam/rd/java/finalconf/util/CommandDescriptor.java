package com.epam.rd.java.finalconf.util;

import com.epam.rd.java.finalconf.command.*;
import com.epam.rd.java.finalconf.dao.connection.DAOFactory;
import com.epam.rd.java.finalconf.service.impl.*;

import java.util.HashMap;
import java.util.Map;

import static com.epam.rd.java.finalconf.util.Resolver.resolve;

public class CommandDescriptor {
    private static final ServiceSecurity securityService = new ServiceSecurity();
    private static final UserService userService = new UserService(DAOFactory.createUserDao(), securityService);
    private static final EventService eventService = new EventService();
    private static final TopicService topicService = new TopicService();
    private static final ParticipantService participantService = new ParticipantService();

    private static final Map<String, Command> commands = new HashMap<>() {{
        put("logout", new Logout());
        put("login", new Login(userService, securityService));
        put("registration", new Registration(userService));
        put("index", new Index(eventService));
        put("register/event", new RegisterToEvent(eventService, securityService));
        put("event/all", new ModeratorGetAllEvents(eventService));
        put("event/create", new ModeratorCreateEvent(eventService));
        put("event/edit", new ModeratorEditEvent(eventService, topicService));
        put("event/delete", new ModeratorDeleteEvent(eventService));
        put("event/topic/add", new ModeratorCreateTopic(eventService));
        put("event/assign/speaker", new ModeratorAssignSpeaker(userService, topicService));
        put("index/cabinet-entrance", new SpeakerEvents(securityService, eventService, participantService));

    }};

    public static Command getCommand(String path) {
        return commands.getOrDefault(path, (def) -> resolve("login"));
    }

}
