package com.study.springboot.service;

import com.study.springboot.domain.dto.TalkDTO;

import java.util.List;

public interface TalkService {
    long addTalkToConference(TalkDTO talk, long conferenceId);
    List<TalkDTO> findTalksByConference(long conferenceId);
}
