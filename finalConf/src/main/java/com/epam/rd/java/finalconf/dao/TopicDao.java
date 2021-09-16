package com.epam.rd.java.finalconf.dao;

import com.epam.rd.java.finalconf.entity.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicDao extends MainDao<Topic> {
    List<Topic> findByEventId(long eventId);
    Optional<Topic> updateTopic(Topic topic);
}
