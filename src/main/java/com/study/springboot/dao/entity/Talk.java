package com.study.springboot.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private String speakerName;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TypeTalk typeTalk;

    @NonNull
    private Date dtApply;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    /*public TalkDTO toDTO(){
        return new TalkDTO(this.getName(), this.getDescription(), this.getSpeakerName(), this.getTypeTalk());
    }*/

}
