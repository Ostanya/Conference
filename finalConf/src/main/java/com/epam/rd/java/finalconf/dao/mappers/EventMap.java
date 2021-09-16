package com.epam.rd.java.finalconf.dao.mappers;

import com.epam.rd.java.finalconf.entity.Event;
import com.epam.rd.java.finalconf.entity.Participant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventMap implements ObjectMapper{
    @Override
    public Event extract(ResultSet rs) throws SQLException {
        return Optional.ofNullable(Event.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .scheduledDate(rs.getObject(3, LocalDateTime.class))
                .build()).orElseThrow(SQLException::new);
    }

    @Override
    public List<Event> extractAll(ResultSet rs) throws SQLException {
        List<Event> list = new ArrayList<>();
        rs.beforeFirst();

        while (rs.next()) {
            Event event = extract(rs);
            list.add(event);
        }
        return list;
    }

    public Participant convertEventRegisterDtoToParticipant(EventRegisterDto eventRegDto, Event event) {
        if (eventRegDto == null) {
            return null;
        }
        Participant participant = new Participant();
        participant.setNickName(eventRegDto.getNickName());
        participant.setSpeaker(eventRegDto.getSpeaker());
        return participant;
    }
}
