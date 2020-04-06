package com.study.springboot.controller;

import com.study.springboot.domain.Talk;
import com.study.springboot.service.TalkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TalkController {
    private final TalkService talkService;

    @RequestMapping(method = RequestMethod.POST, path = "/conferences/{conference_id}/talks", produces = "application/json")
    public ResponseEntity<Talk> addTalks(@RequestBody Talk talk, @PathVariable Long conference_id) {
        Talk talkNew = talkService.addTalk(talk, conference_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(talkNew);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/conferences/{conference_id}/talks", produces = "application/json")
    public @ResponseBody List<Talk> findTalks(@PathVariable Long conference_id) {
         return talkService.findTalksByConference(conference_id);
    }
}
