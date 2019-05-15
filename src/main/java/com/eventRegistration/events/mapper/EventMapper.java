package com.eventRegistration.events.mapper;

import com.eventRegistration.entity.ErSlEvents;
import com.eventRegistration.events.dto.EventDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto entityToDto(ErSlEvents erSlEvents);

    ErSlEvents dtoToEntity(EventDto eventDto);

    List<EventDto> entitysToDtos(List<ErSlEvents> erSlEvents);

    ErSlEvents updateEntityFromDto(@MappingTarget ErSlEvents erSlEvents, EventDto eventDto);
}
