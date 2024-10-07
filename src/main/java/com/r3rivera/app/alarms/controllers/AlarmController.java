package com.r3rivera.app.alarms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.r3rivera.app.alarms.exceptions.DataProcessException;
import com.r3rivera.app.alarms.exceptions.DataProcessRuntimeException;
import com.r3rivera.app.alarms.models.AlarmEventRequest;
import com.r3rivera.app.alarms.models.EventTypes;
import com.r3rivera.app.alarms.utils.DateUtil;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class AlarmController {



    @PostMapping("/event")
    public ResponseEntity<String> processRequest(@Valid @RequestBody AlarmEventRequest alarmEvent){
        log.debug("## Processing Request!");
        log.debug("Request paylaod is {}", alarmEvent);
        log.debug("Timestamp Type is {}?", DateUtil.formatUTC(alarmEvent.getTimestampUtc(), null));
        try{
            process(alarmEvent);
        }catch(DataProcessException e){
            return ResponseEntity.internalServerError().body("Checked Exception");
        }catch(DataProcessRuntimeException e){
            return ResponseEntity.internalServerError().body("Runtime Exception");
        }catch(Exception e){
            return ResponseEntity.internalServerError().body("Generic Error");
        }
        return ResponseEntity.ok("Success");
    }

    private void process(AlarmEventRequest event) throws DataProcessException{

        final String enumString = event.getEventType();
        final EventTypes e = EventTypes.fromValue(enumString);
        switch (e) {
            case BOUNCED -> {
                log.debug("Throwing a Checked exception");
                throw new DataProcessException("Check Exception");
            }
            case NOT_SENT -> {
                log.debug("Throwing a Runtime exception");
                throw new DataProcessRuntimeException("Check Exception");
            }
            default -> log.debug("Success");
        }


    }
}
