package com.eventRegistration.events.controller;

import com.eventRegistration.events.dto.EventDto;
import com.eventRegistration.events.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public List<EventDto> getAll() {
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public EventDto getOne(@PathVariable Long id) {
        return eventService.getById(id);
    }

    @PostMapping
    public EventDto save(@RequestBody @Valid EventDto eventDto) {
        return eventService.save(eventDto);
    }

    @PutMapping
    public EventDto update(@RequestBody @Valid EventDto eventDto) {
        return eventService.update(eventDto);
    }
}
