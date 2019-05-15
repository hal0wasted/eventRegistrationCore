package com.eventRegistration.eventRegistration.service.impl;

import com.eventRegistration.entity.ErEventRegistrations;
import com.eventRegistration.eventRegistration.dto.EventRegistrationDto;
import com.eventRegistration.eventRegistration.exceptions.UserAlreadyRegisteredException;
import com.eventRegistration.eventRegistration.mapper.EventRegistrationMapper;
import com.eventRegistration.eventRegistration.repository.EventRegistrationRepository;
import com.eventRegistration.eventRegistration.service.EventRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventRegistrationServiceImpl implements EventRegistrationService {

    private final EventRegistrationRepository eventRegistrationRepository;
    private final EventRegistrationMapper eventRegistrationMapper;

    @Override
    public EventRegistrationDto save(EventRegistrationDto eventRegistrationDto) throws UserAlreadyRegisteredException {

        if (!isUserRegistered(eventRegistrationDto.getUserId(), eventRegistrationDto.getEventId())) {
            ErEventRegistrations erEventRegistrations = eventRegistrationMapper.dtoToEntity(eventRegistrationDto);
            erEventRegistrations = eventRegistrationRepository.saveAndFlush(erEventRegistrations);
            return eventRegistrationMapper.entityToDto(erEventRegistrations);

        } else throw new UserAlreadyRegisteredException();
    }

    @Override
    public Boolean isUserRegistered(Long userId, Long eventId) {
        return eventRegistrationRepository.findOneByUserIdAndEventId(eventId, userId).isPresent();
    }
}
