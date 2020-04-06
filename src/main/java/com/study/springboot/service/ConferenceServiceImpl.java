package com.study.springboot.service;

import com.study.springboot.domain.Conference;
import com.study.springboot.exception.BadRequestException;
import com.study.springboot.exception.ConflictException;
import com.study.springboot.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private static final String MSG_UNIQ_NAME = "конференция с таким названием уже существует";
    private static final String MSG_NUMBER_OF_PARTICIPANTS = "количество учасников должно быть > 100";
    private static final String MSG_DO_NOT_DATE_CROSS = "даты конференций не должны пересекаться";

    private final ConferenceRepository conferenceRepository;

    public ConferenceServiceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }
    //TODO: вопрос @Repository & @Autowired

    @Override
    public Conference addConference(Conference conference) {
        if (conference != null) {
            if (isValid(conference)) {
                Conference conferenceNew = new Conference(conference.getName(), conference.getTopic(),
                        conference.getDtStart(), conference.getDtEnd(), conference.getNumberOfParticipants());

                return conferenceRepository.saveAndFlush(conferenceNew);
            }
        }
        return null;
    }

    @Override
    public Conference changeConference(Conference conference, Long conference_id) {
        Optional<Conference> optinalEntity = conferenceRepository.findById(conference_id);
        if(optinalEntity.isPresent()){
            Conference conferenceEdit = optinalEntity.get();
            if (isValid(conference)) {
                conferenceEdit.setName(conference.getName());
                conferenceEdit.setTopic(conference.getTopic());
                conferenceEdit.setDtStart(conference.getDtStart());
                conferenceEdit.setDtEnd(conference.getDtEnd());
                conferenceEdit.setNumberOfParticipants(conference.getNumberOfParticipants());
                return conferenceRepository.saveAndFlush(conferenceEdit);
            }
        }
        return  null;

    }

    @Override
    public List<Conference> findAllConferences() {
        return conferenceRepository.findAll();
    }

    private boolean isValid(Conference conference){
        /*- конференции уникальны по имени, при попытке добавить дубликат должен возвращаться 409 HTTP статус

           - все поля у конференции и доклада обязательные и должны быть не пустыми,
             количество учасников > 100, при нарушении этих правил должен возращаться 400 HTTP статус

           - даты конференций не должны пересекаться, иначе возращаться 400 HTTP статус
*/
        Long id = (conference.getId() == null)?-1:conference.getId();
        List<Conference> conferenceList = conferenceRepository.findByNameAndIdNot(conference.getName(), id);
        if(!conferenceList.isEmpty()){
            throw new ConflictException(MSG_UNIQ_NAME);
        }
        if (conference.getNumberOfParticipants() < 100){
            throw new BadRequestException(MSG_NUMBER_OF_PARTICIPANTS);
        }
        conferenceList = conferenceRepository.findByDtEndAfterAndDtStartBefore(conference.getDtStart(), conference.getDtEnd());
        if(!conferenceList.isEmpty()){
            throw new BadRequestException(MSG_DO_NOT_DATE_CROSS);
        }
        return true;
    }
}
