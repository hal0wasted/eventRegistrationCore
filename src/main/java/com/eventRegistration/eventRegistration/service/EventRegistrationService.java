package com.eventRegistration.eventRegistration.service;

import com.eventRegistration.eventRegistration.dto.EventRegistrationDto;
import com.eventRegistration.eventRegistration.exceptions.UserAlreadyRegisteredException;

public interface EventRegistrationService {

    EventRegistrationDto save(EventRegistrationDto eventRegistrationDto) throws UserAlreadyRegisteredException;

    Boolean isUserRegistered(Long userId, Long eventId);
}
