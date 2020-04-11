package com.study.springboot.web.api;

import com.study.springboot.domain.dto.TalkDTO;
import com.study.springboot.exception.talk.*;
import com.study.springboot.service.TalkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TalkController {
    private final TalkService talkService;

    @PostMapping("/conferences/{conference_id}/talks")
    @ResponseStatus(HttpStatus.CREATED)
    public long addTalks(@RequestBody TalkDTO talk, @PathVariable Long conference_id) {
        return talkService.addTalkToConference(talk, conference_id);
    }

    @GetMapping(path = "/conferences/{conference_id}/talks")
    @ResponseStatus(HttpStatus.OK)
    public List<TalkDTO> findTalks(@PathVariable Long conference_id) {
         return talkService.findTalksByConference(conference_id);
    }

    @ExceptionHandler({NullTalkException.class,
            EmptyFieldTalkException.class,
            TooManyTalksPerParticipantException.class,
            TooLateApplyTalkException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleAllBadRequestExceptions(Exception ex) {
    }

    @ExceptionHandler(TalkNameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleAllConflictExceptions(Exception ex) {
    }

}
