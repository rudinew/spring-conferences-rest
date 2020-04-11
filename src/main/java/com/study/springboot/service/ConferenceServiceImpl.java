package com.study.springboot.service;

import com.study.springboot.dao.entity.Conference;
import com.study.springboot.domain.dto.ConferenceDTO;
import com.study.springboot.dao.repository.ConferenceRepository;
import com.study.springboot.domain.mapper.ConferenceMapper;
import com.study.springboot.exception.conference.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;

    @Override
    public long addConference(ConferenceDTO conference) {
        checkValid(conference, -1);
        Conference conferenceNew = new Conference(conference.getName(), conference.getTopic(),
                        conference.getDtStart(), conference.getDtEnd(), conference.getNumberOfParticipants());
        ///dto - entity (в конструкторе учесть dto)   CreateConferenceDto   //packet dto
        conferenceNew = conferenceRepository.saveAndFlush(conferenceNew);
        return conferenceNew.getId();

    }

    @Override
    public void changeConference(ConferenceDTO conference, long conferenceId) {   // UpdateConferenceRequest    Dto   //packet dto
        Optional<Conference> optinalEntity = conferenceRepository.findById(conferenceId);
        checkValid(conference, conferenceId);
        if(optinalEntity.isPresent()){
            Conference conferenceEdit = optinalEntity.get();
            conferenceEdit.setName(conference.getName());
            conferenceEdit.setTopic(conference.getTopic());
            conferenceEdit.setDtStart(conference.getDtStart());
            conferenceEdit.setDtEnd(conference.getDtEnd());
            conferenceEdit.setNumberOfParticipants(conference.getNumberOfParticipants());
            conferenceRepository.saveAndFlush(conferenceEdit);
        }
    }

    @Override
    public List<ConferenceDTO> findAllConferences() {
        List<Conference> conferenceList = conferenceRepository.findAll();
        List<ConferenceDTO> conferenceDTOList = new ArrayList<>();
        for(Conference conference: conferenceList){
            conferenceDTOList.add(ConferenceMapper.toConferenceDTO(conference));
        }
        return conferenceDTOList;
    }

    private void checkValid(Object conference, long conferenceId){
        /*- конференции уникальны по имени, при попытке добавить дубликат должен возвращаться 409 HTTP статус

           - все поля у конференции и доклада обязательные и должны быть не пустыми,
             количество учасников > 100, при нарушении этих правил должен возращаться 400 HTTP статус

           - даты конференций не должны пересекаться, иначе возращаться 400 HTTP статус
        */
        if (conference == null) { throw  new NullConferenceException(); }
        if(conference instanceof  ConferenceDTO){
            ConferenceDTO conferenceDTO = (ConferenceDTO) conference;

            if(conferenceDTO.getName() == null || conferenceDTO.getTopic() == null
              || conferenceDTO.getDtStart() == null || conferenceDTO.getDtEnd() == null
              || conferenceDTO.getNumberOfParticipants() == null){
                throw  new EmptyFieldConferenceException();
            }
            if(conferenceRepository.countByNameAndIdNot(conferenceDTO.getName(), conferenceId) > 0){
                throw new ConferenceNameAlreadyExistsException();
            }
            if (conferenceDTO.getNumberOfParticipants() < 100){
                throw new NotEnoughParticipantsConferenceException();
            }
            if(conferenceRepository.countByDtEndAfterAndDtStartBefore(conferenceDTO.getDtStart(), conferenceDTO.getDtEnd()) > 0){
                throw new DateCrossConferenceException();
            }
        }

    }


}
