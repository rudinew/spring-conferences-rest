package com.study.springboot.service;

import com.study.springboot.domain.Conference;
import com.study.springboot.domain.Talk;
import com.study.springboot.exception.BadRequestException;
import com.study.springboot.exception.ConflictException;
import com.study.springboot.repository.ConferenceRepository;
import com.study.springboot.repository.TalkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class TalkServiceImpl implements TalkService {

    private final TalkRepository talkRepository;
    private final ConferenceRepository conferenceRepository;
    private static final String MSG_LIMIT_NUMBER_SPEAKER_TALK = "докладчик не может подать больше 3 докладов";
    private static final String MSG_LATE_POST_TALK = "подача докладов разрешена не позже чем за месяц до начала конференции";
    private static final String MSG_UNIQ_NAME_TALK = "доклад с таким названием уже существует";
    private static final long MIN_DAYS_BEFORE_CONFERENCE = 31;

    @Override
    public Talk addTalk(Talk talk, Long conferenceId) {

        Optional<Conference> conference = conferenceRepository.findById(conferenceId);
        if(conference.isPresent() && talk != null){
            if (isValid(talk, conference.get())) {
                Date dtApply = new Date();
                Talk talkNew = new Talk(talk.getName(), talk.getDescription(),
                        talk.getSpeakerName(), talk.getTypeTalk(), dtApply, conference.get());
                return talkRepository.saveAndFlush(talkNew);
            }
        }
        return  null;

    }

    @Override
    public List<Talk> findTalksByConference(Long conferenceId) {
        return talkRepository.findByConferenceIdOrderBySpeakerNameAsc(conferenceId);
    }

    //https://howtodoinjava.com/java/date-time/duration-between-two-dates/
    private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit)
    {
        long diffInMillies = date2.getTime() - date1.getTime();

        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    private boolean isValid(Talk talk, Conference conference){
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

        if(talkRepository.countByConferenceIdAndSpeakerName(conference.getId(), talk.getSpeakerName()) >= 3){
            throw new BadRequestException(MSG_LIMIT_NUMBER_SPEAKER_TALK);
        }
        Date dtApply = new Date();
        Date dtStartConference = conference.getDtStart();
        long diffDays = getDateDiff(dtApply, dtStartConference, TimeUnit.DAYS);
        if (diffDays < MIN_DAYS_BEFORE_CONFERENCE){
            throw new BadRequestException(MSG_LATE_POST_TALK);
        }
        List<Talk> talkList = talkRepository.findByConferenceIdAndNameOrderByNameAsc(conference.getId(), talk.getName());
        if(!talkList.isEmpty()){
            throw new ConflictException(MSG_UNIQ_NAME_TALK);
        }

        return true;
    }
}
