package com.study.springboot.web.api;

import com.study.springboot.domain.dto.ConferenceDTO;
import com.study.springboot.exception.conference.*;
import com.study.springboot.service.ConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ConferenceController {
    private final ConferenceService conferenceService;

    @GetMapping("/conferences")
    @ResponseStatus(HttpStatus.OK)
    public List<ConferenceDTO> findConferences() {
        return conferenceService.findAllConferences();
    }

    @PostMapping("/conferences")
    @ResponseStatus(HttpStatus.CREATED)
    public long addConferences(@RequestBody ConferenceDTO conference) {
        return conferenceService.addConference(conference);
    }

    @PutMapping( "/conferences/{conference_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateConferences(@RequestBody ConferenceDTO conference, @PathVariable Long conference_id) {
        conferenceService.changeConference(conference, conference_id);
    }

    @ExceptionHandler({NullConferenceException.class,
                       DateCrossConferenceException.class,
                       EmptyFieldConferenceException.class,
                       NotEnoughParticipantsConferenceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleAllBadRequestExceptions(Exception ex) {
    }

    @ExceptionHandler(ConferenceNameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleAllConflictExceptions(Exception ex) {
    }

    /* частные случаи обработки ошибок в Controller
      использовать для общих
      @ControllerAdvice
      class ErrorMapping*/
}
