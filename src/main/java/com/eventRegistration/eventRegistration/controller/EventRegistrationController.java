package com.eventRegistration.eventRegistration.controller;

import com.eventRegistration.eventRegistration.dto.EventRegistrationDto;
import com.eventRegistration.eventRegistration.service.EventRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eventRegistration")
@RequiredArgsConstructor
public class EventRegistrationController {

    private final EventRegistrationService eventRegistrationService;

    @PostMapping
    @SneakyThrows
    public EventRegistrationDto save(@RequestBody EventRegistrationDto eventRegistrationDto) {
        return eventRegistrationService.save(eventRegistrationDto);
    }
}
