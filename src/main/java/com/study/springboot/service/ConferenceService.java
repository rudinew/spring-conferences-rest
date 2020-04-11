package com.study.springboot.service;

import com.study.springboot.domain.dto.ConferenceDTO;

import java.util.List;

public interface ConferenceService {

    long addConference(ConferenceDTO conference);  /*рекомендация: возращать long а не Conference*/

    void changeConference(ConferenceDTO conference, long conferenceId);   /*рекомендация: возращать void а не Conference*/

    List<ConferenceDTO> findAllConferences();

}
