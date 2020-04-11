package com.study.springboot.domain.dto;

import com.study.springboot.dao.entity.TypeTalk;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class TalkDTO {
    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private String speakerName;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TypeTalk typeTalk;
}
