package com.epam.rd.java.finalconf.service.impl;

import com.epam.rd.java.finalconf.dao.EventDao;
import com.epam.rd.java.finalconf.dao.ParticipantDao;
import com.epam.rd.java.finalconf.dao.TopicDao;
import com.epam.rd.java.finalconf.dao.UserDao;
import com.epam.rd.java.finalconf.dao.connection.DAOFactory;
import com.epam.rd.java.finalconf.dto.DtoEvent;
import com.epam.rd.java.finalconf.entity.*;
import com.epam.rd.java.finalconf.util.exeption.EventDeletedExept;
import com.epam.rd.java.finalconf.util.exeption.EventNotFoundExept;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventService {
    private final EventDao eventDao = DAOFactory.createEventDao();
    private final UserDao userDao = DAOFactory.createUserDao();
    private final TopicDao topicDao = DAOFactory.createTopicDao();
    private final ParticipantDao participantDao = DAOFactory.createParticipantDao();

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Optional<Event> createEvent(String title, String scheduledDate) {
        return eventDao.save(Event.builder()
                .title(title)
                .scheduledDate(LocalDateTime.parse(scheduledDate))
                .build());
    }

    public List<DtoEvent> getAllEvents() {
        List<Event> events = eventDao.findAll();
        if (events == null) {
            return null;
        }
        List<DtoEvent> list = new ArrayList<>();
        for (Event event : events) {
            list.add(convertEventToEventDto(event));
        }
        return list;
    }

    public DtoEvent convertEventToEventDto(Event event) {
        if (event == null) {
            return null;
        }
        var eventDto = new DtoEvent();

        eventDto.setId(event.getId());
        eventDto.setTitle(event.getTitle());
        eventDto.setScheduledDate(event.getScheduledDate().format(formatter));
        return eventDto;
    }

    public DtoEvent getEventById(long id) {
        Optional<Event> event = eventDao.findById(id);
        return event.map(this::convertEventToEventDto)
                .orElseThrow(() -> new EventNotFoundExept("event.not.found"));
    }

    public void registerToEvent(long eventId, String nickName, Boolean isSpeaker, User user) {
        Participant participant = new Participant();

        participant.setNickName(nickName);
        participant.setSpeaker(isSpeaker);
        participant.setEventId(eventId);
        participant.setUserId(user.getId());

        if (isSpeaker) {
            user.setRole(Role.SPEAKER);
            userDao.updateUserRole(user);
        }
        participantDao.save(participant);
    }

    public boolean deleteById(long id) throws EventDeletedExept {
        return eventDao.deleteById(id);
    }

    public Optional<Event> updateEvent(long id, String title, String scheduledDate) {
        return eventDao.update(Event.builder()
                .id(id)
                .title(title)
                .scheduledDate(LocalDateTime.parse(scheduledDate))
                .build());

    }

    public Topic createTopic(String title, long eventId) {
        Topic topic = Topic.builder()
                .title(title)
                .eventId(eventId).build();


        topicDao.save(topic);
        return topic;
    }

    public List<Event> findByIdIn(List<Long> eventIds) {
        return eventDao.findByIdIn(eventIds);
    }
}
