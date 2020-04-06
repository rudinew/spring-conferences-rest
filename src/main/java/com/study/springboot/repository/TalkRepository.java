package com.study.springboot.repository;

import com.study.springboot.domain.Talk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalkRepository extends JpaRepository<Talk, Long> {

    List<Talk> findByConferenceIdOrderBySpeakerNameAsc(Long conferenceId);

    List<Talk> findByConferenceIdAndNameOrderByNameAsc(Long conferenceId, String name);

    List<Talk> findByConferenceIdAndSpeakerNameOrderBySpeakerNameAsc(Long conferenceId, String speakerName);

    long countByConferenceIdAndSpeakerName(Long conferenceId, String speakerName);
}
