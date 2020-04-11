package com.study.springboot.service;

import com.study.springboot.config.ConferenceSettings;
import com.study.springboot.dao.entity.Conference;
import com.study.springboot.dao.entity.Talk;
import com.study.springboot.domain.dto.TalkDTO;
import com.study.springboot.dao.repository.ConferenceRepository;
import com.study.springboot.dao.repository.TalkRepository;
import com.study.springboot.domain.mapper.TalkMapper;
import com.study.springboot.exception.conference.NullConferenceException;
import com.study.springboot.exception.talk.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class TalkServiceImpl implements TalkService {

    private final TalkRepository talkRepository;
    private final ConferenceRepository conferenceRepository;
    private final ConferenceSettings settings;

    @Override
    public long addTalkToConference(TalkDTO talk, long conferenceId) {
        Optional<Conference> conference = conferenceRepository.findById(conferenceId);
         checkValid(talk, conference.get());
         Date dtApply = new Date();
         Talk talkNew = new Talk(talk.getName(), talk.getDescription(),
                        talk.getSpeakerName(), talk.getTypeTalk(), dtApply, conference.get());
         talkNew = talkRepository.saveAndFlush(talkNew);
         return talkNew.getId();
    }

    @Override
    public  List<TalkDTO> findTalksByConference(long conferenceId) {
        List<Talk> talkList = talkRepository.findByConferenceIdOrderBySpeakerNameAsc(conferenceId);
        List<TalkDTO> talkDTOList = new ArrayList<>();
        for(Talk talk: talkList){
            talkDTOList.add(TalkMapper.roTalkDTO(talk));
        }
        return talkDTOList;
    }

    private void checkValid(TalkDTO talkDTO, Conference conference) {
        /*
         * все поля у доклада обязательные и должны быть не пустыми,
         * при нарушении этих правил должен возращаться 400 HTTP статус
         *
         * докладчик не может подать больше 3 докладов, при попытке подать больше возращаеться 400 HTTP статус
         *
         * доклады уникальны по названию, при попытке добавить дубликат должен возращаться 409 HTTP статус
         *
         * подача докладов разрешена не позже чем за месяц до начала конференции, иначе возращается 400 HTTP статус
         * */
        if (conference == null) { throw new NullConferenceException(); }
        if (talkDTO == null) { throw new NullTalkException(); }

        if(talkDTO.getName() == null || talkDTO.getDescription() == null
               || talkDTO.getSpeakerName() == null || talkDTO.getTypeTalk() == null){
            throw  new EmptyFieldTalkException();
        }

        if(talkRepository.countByConferenceIdAndSpeakerName(conference.getId(), talkDTO.getSpeakerName()) >= settings.getMin_talks_per_participant()){
            throw new TooManyTalksPerParticipantException();
        }

        Date dtApply = new Date();
        Date dtStartConference = conference.getDtStart();
        long diffDays = getDateDiff(dtApply, dtStartConference, TimeUnit.DAYS);
        if (diffDays < settings.getMin_days_before_conference()){
            throw new TooLateApplyTalkException();
        }

        if(talkRepository.countByConferenceIdAndNameOrderByNameAsc(conference.getId(), talkDTO.getName()) > 0){
                throw new TalkNameAlreadyExistsException();
        }

    }

    //https://howtodoinjava.com/java/date-time/duration-between-two-dates/
    private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit)
    {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
