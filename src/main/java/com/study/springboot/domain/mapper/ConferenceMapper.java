package com.study.springboot.domain.mapper;

import com.study.springboot.dao.entity.Conference;
import com.study.springboot.domain.dto.ConferenceDTO;

public class ConferenceMapper {
    public static ConferenceDTO toConferenceDTO(Conference conference) {
        return new ConferenceDTO(conference.getName(),
                conference.getTopic(), conference.getDtStart(), conference.getDtEnd(),
                conference.getNumberOfParticipants());
    }
}

