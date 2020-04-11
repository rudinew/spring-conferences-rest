package com.study.springboot.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class ConferenceDTO  {

    @NonNull
    private String name;

    @NonNull
    private String topic;

    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dtStart;

    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dtEnd;

    @NonNull
    private Integer numberOfParticipants;
}
