package com.study.springboot.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.springboot.domain.dto.ConferenceDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
  //  @Column(nullable=false, unique=true)  ///это работает при создании таблицы, смотри spring.jpa.hibernate.ddl-auto
    private String name;

    @NonNull
    private String topic;

    @NonNull
   /// @Column(name = "dt_start")  // dt_start == dtStart
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dtStart;

    @NonNull
    private Date dtEnd;

    @NonNull
    private Integer numberOfParticipants;



   /* @OneToMany(mappedBy="conference" , fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
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
