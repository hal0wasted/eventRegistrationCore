package com.eventRegistration.events.service;

import com.eventRegistration.events.dto.EventDto;
import com.eventRegistration.events.exceptions.NoSuchEventException;

import java.util.List;

public interface EventService {

    EventDto save(EventDto eventDto);

    EventDto update(EventDto eventDto) throws NoSuchEventException;

    void delete(EventDto eventDto) throws NoSuchEventException;

    List<EventDto> getAll();

    EventDto getById(Long id) throws NoSuchEventException;

    EventDto getByName(String eventName);
}
