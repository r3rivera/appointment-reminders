package com.r3rivera.app.alarms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {

    
    @GetMapping("/health")
    public String healthCheck(){
        return "OK";
    }
}
