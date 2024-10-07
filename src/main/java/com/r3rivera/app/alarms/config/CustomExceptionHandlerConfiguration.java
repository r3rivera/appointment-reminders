package com.r3rivera.app.alarms.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandlerConfiguration {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> fieldValidationExceptions(MethodArgumentNotValidException ex){
        final Map<String, String> errors = new HashMap<>();
        log.error("Field Validation Error Found!");
        ex.getBindingResult().getAllErrors().forEach( err -> {
            if(err instanceof FieldError fieldError){
                final FieldError e = fieldError;
                errors.put(e.getField(), e.getDefaultMessage());
            }
        });

        return ResponseEntity.badRequest().body(errors);
    }

    /* 
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> fieldValidationEnum(HttpMessageNotReadableException ex){

        log.error("Enum Field Validation Error Found!" + ex.getMessage());
        return ResponseEntity.badRequest().body("BADDD");
    }
    */

}
