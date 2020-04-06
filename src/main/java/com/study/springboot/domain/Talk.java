package com.study.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
/*TODO: вопрос import javax.validation.constraints.NotNull
  lombok.NonNull
*/


@Getter
@Setter
@ToString
@Entity
@Table(name="talk")
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @NotEmpty(message="заполните название доклада")
    @NonNull
    @Column(nullable=false, unique=true)
    private String name;

   // @NotEmpty(message="заполните описание доклада")
    @NonNull
    private String description;

    @NonNull
    @Column(name = "speaker_name", nullable = false)
    private String speakerName;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type_talk", nullable = false)
    private TypeTalk typeTalk;

    @NonNull
    @Column(name = "dt_apply")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dtApply;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "conference_id", nullable=false)
    private Conference conference;

    public Talk() {
    }

    public Talk(@NonNull String name, @NonNull String description, @NonNull String speakerName, @NonNull TypeTalk typeTalk, @NonNull Date dtApply, Conference conference) {
        this.name = name;
        this.description = description;
        this.speakerName = speakerName;
        this.typeTalk = typeTalk;
        this.dtApply = dtApply;
        this.conference = conference;
    }
}
