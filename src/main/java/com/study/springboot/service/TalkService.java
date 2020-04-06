package com.study.springboot.service;

import com.study.springboot.domain.Talk;

import java.util.List;

public interface TalkService {
    Talk addTalk(Talk talk, Long conferenceId);
    List<Talk> findTalksByConference(Long conferenceId);
}
