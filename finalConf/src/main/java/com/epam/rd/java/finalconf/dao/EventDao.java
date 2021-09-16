package com.epam.rd.java.finalconf.dao;

import com.epam.rd.java.finalconf.entity.Event;

import java.util.List;

public interface EventDao extends MainDao<Event> {
    boolean deleteById(long id);

    List<Event> findByIdIn(List<Long> eventIds);
}
