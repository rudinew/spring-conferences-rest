package com.study.springboot.dao.repository;

import com.study.springboot.dao.entity.Talk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalkRepository extends JpaRepository<Talk, Long> {

    List<Talk> findByConferenceIdOrderBySpeakerNameAsc(Long conferenceId);

    long countByConferenceIdAndNameOrderByNameAsc(Long conferenceId, String name);

    long countByConferenceIdAndSpeakerName(Long conferenceId, String speakerName);
}
