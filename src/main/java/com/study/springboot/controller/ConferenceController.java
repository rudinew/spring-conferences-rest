package com.study.springboot.controller;

import com.study.springboot.domain.Conference;
import com.study.springboot.service.ConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ConferenceController {
    private final ConferenceService conferenceService;

    @RequestMapping(method = RequestMethod.GET, path = "/conferences", produces = "application/json")
    public @ResponseBody List<Conference> findConferences() {

        return conferenceService.findAllConferences();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/conferences", produces = "application/json")
    public ResponseEntity<Conference> addConferences(@RequestBody Conference conference) {
        Conference conferenceNew = conferenceService.addConference(conference);
        return ResponseEntity.status(HttpStatus.CREATED).body(conferenceNew);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/conferences/{conference_id}", produces = "application/json")
    public ResponseEntity<Conference> updateConferences(@RequestBody Conference conference, @PathVariable Long conference_id) {
        Conference conferenceEdit = conferenceService.changeConference(conference, conference_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(conferenceEdit);
    }


}
