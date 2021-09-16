package com.epam.rd.java.finalconf.dao;

import com.epam.rd.java.finalconf.entity.Participant;

import java.util.List;

public interface ParticipantDao extends MainDao<Participant>{
    List<Participant> findByUserId(long userId);
}
