package com.study.springboot.domain.mapper;

import com.study.springboot.dao.entity.Talk;
import com.study.springboot.domain.dto.TalkDTO;

public class TalkMapper {
    public static TalkDTO roTalkDTO(Talk talk){
        return new TalkDTO(talk.getName(), talk.getDescription(), talk.getSpeakerName(), talk.getTypeTalk());
    }
}
