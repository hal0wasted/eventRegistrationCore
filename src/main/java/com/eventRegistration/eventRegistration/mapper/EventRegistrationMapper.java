package com.eventRegistration.eventRegistration.mapper;

import com.eventRegistration.entity.ErEventRegistrations;
import com.eventRegistration.eventRegistration.dto.EventRegistrationDto;
import com.eventRegistration.events.repository.EventRepository;
import com.eventRegistration.users.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class EventRegistrationMapper {

    private EventRepository eventRepository;
    private UserRepository userRepository;

    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "user.id", target = "userId")
    public abstract EventRegistrationDto entityToDto(ErEventRegistrations erEventRegistrations);

    public ErEventRegistrations dtoToEntity(EventRegistrationDto eventRegistrationDto) {
        ErEventRegistrations erEventRegistrations = new ErEventRegistrations();
        if (!Objects.isNull(eventRegistrationDto)) {
            erEventRegistrations.setId(eventRegistrationDto.getId());
            erEventRegistrations.setEvent(eventRepository.getOne(eventRegistrationDto.getEventId()));
            erEventRegistrations.setUser(userRepository.getOne(eventRegistrationDto.getUserId()));
        }
        return erEventRegistrations;
    }


    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
