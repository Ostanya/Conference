package com.epam.rd.java.finalconf.entity.repository;

import com.epam.rd.java.finalconf.entity.Event;

import java.util.LinkedList;
import java.util.List;

public class EventRepository {
    private final List<Event> eventList;
    private static EventRepository eventRepository;

    public EventRepository() {
        eventList = new LinkedList<>();
        eventList.add(new Event("Test1", "test1"));
        eventList.add(new Event("Test2", "test2"));
        eventList.add(new Event("Test3", "test3"));
    }

    public static EventRepository getEventRepository() {
        if(eventRepository == null) {
            eventRepository = new EventRepository();
        }
        return eventRepository;
    }

    public boolean delete(int id) {
        Event event = read(id);
        if(event != null) {
            return eventList.remove(event);
        }
        return false;
    }

    public List<Event> all() {
        return eventList;
    }

    public Event read(int id) {
        return eventList.stream()
                .filter(event -> event.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean update(Event newEvent) {
        Event oldEvent = read(newEvent.getId());
        if(oldEvent != null) {
            boolean status = all().stream()
                    .filter(event -> event.getId() != oldEvent.getId())
                    .anyMatch(event -> event.getTopic().equals(newEvent.getTopic()));
            if(!status) {
                return eventList.set(eventList.indexOf(oldEvent), newEvent) != null;
            }
            return false;
        }
        return false;
    }

    public boolean create(Event event) {
        boolean status = eventList.stream()
                .anyMatch(s -> s.getTopic()
                        .equals(event.getTopic()));
        if(!status) {
            return eventList.add(event);
        }
        return false;
    }
}
