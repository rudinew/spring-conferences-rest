package com.study.springboot.service;

import com.study.springboot.domain.Conference;

import java.util.List;

public interface ConferenceService {

    Conference addConference(Conference conference);

    Conference changeConference(Conference conference, Long conference_id);

    List<Conference> findAllConferences();

}
