package com.study.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable=false, unique=true)
    private String name;

    @NonNull
    private String topic;

    @NonNull
    @Column(name = "dt_start")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dtStart;

    @NonNull
    @Column(name = "dt_end")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dtEnd;

    @NonNull
    @Column(name = "number_of_participants")
    private Integer numberOfParticipants;
/*
    @OneToMany(mappedBy="conference" , fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Talk> talkList = new ArrayList<Talk>();

    public  List<Talk> getTalkList() {
        if (this.talkList == null) {
            this.talkList = new ArrayList<Talk>();
        }
        return this.talkList;
    }

    public void setTalk(Talk talk) {
        getTalkList().add(talk);
        talk.setConference(this);
    }

    public int getNrOfTalkList() {
        return getTalkList().size();
    }

*/

}
