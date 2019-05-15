package com.eventRegistration.events.service.impl;

import com.eventRegistration.entity.ErSlEvents;
import com.eventRegistration.events.dto.EventDto;
import com.eventRegistration.events.exceptions.NoSuchEventException;
import com.eventRegistration.events.mapper.EventMapper;
import com.eventRegistration.events.repository.EventRepository;
import com.eventRegistration.events.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public EventDto save(EventDto eventDto) {
        ErSlEvents erSlEvents = eventMapper.dtoToEntity(eventDto);
        erSlEvents = eventRepository.saveAndFlush(erSlEvents);
        return eventMapper.entityToDto(erSlEvents);
    }

    @Override
    public EventDto update(EventDto eventDto) throws NoSuchEventException {
        Optional<ErSlEvents> erSlEvents = eventRepository.findById(eventDto.getId());
        if (erSlEvents.isPresent()) {
            ErSlEvents erSlEvent = erSlEvents.get();
            erSlEvent = eventMapper.updateEntityFromDto(erSlEvent, eventDto);
            erSlEvent = eventRepository.saveAndFlush(erSlEvent);
            return eventMapper.entityToDto(erSlEvent);
        } else throw new NoSuchEventException();
    }

    @Override
    public void delete(EventDto eventDto) throws NoSuchEventException {
        Optional<ErSlEvents> erSlEvents = eventRepository.findById(eventDto.getId());
        erSlEvents.ifPresent(eventRepository::delete);
    }

    @Override
    public List<EventDto> getAll() {
        return eventMapper.entitysToDtos(eventRepository.findAll());
    }

    @Override
    public EventDto getById(Long id) throws NoSuchEventException {
        Optional<ErSlEvents> erSlEvents = eventRepository.findById(id);
        return eventMapper.entityToDto(erSlEvents.orElseThrow(NoSuchEventException::new));
    }

    @Override
    public EventDto getByName(String eventName) {
        Optional<ErSlEvents> erSlEvents = eventRepository.findByName(eventName);
        return eventMapper.entityToDto(erSlEvents.orElseThrow(NoSuchEventException::new));
    }
}
