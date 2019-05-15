package com.eventRegistration.service;

import com.eventRegistration.entity.ErSlEvents;
import com.eventRegistration.events.dto.EventDto;
import com.eventRegistration.events.mapper.EventMapperImpl;
import com.eventRegistration.events.repository.EventRepository;
import com.eventRegistration.events.service.impl.EventServiceImpl;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class EventServiceImplTest {

    private static final Long EVENT_ID = 1L;
    private static final String EVENT_NAME = "Test event";
    private static final Date EVENT_START_DATE = new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime();
    private static final Date EVENT_END_DATE = new GregorianCalendar(2020, Calendar.FEBRUARY, 2).getTime();

    private static final String NEW_EVENT_NAME = "Test event after edit";

    @Mock
    private EventRepository eventRepository;

    private EventMapperImpl eventMapper;
    private EventServiceImpl eventService;

    @BeforeMethod
    private void setUp() {
        initMocks(this);
        eventMapper = new EventMapperImpl();
        eventService = new EventServiceImpl(eventRepository, eventMapper);
    }

    @Test
    private void checkUpdatingEvent() {
        //given
        ErSlEvents existingEvent = ErSlEvents.builder()
                .id(EVENT_ID)
                .name(EVENT_NAME)
                .startDate(EVENT_START_DATE)
                .endDate(EVENT_END_DATE)
                .build();
        ErSlEvents editedEvent = ErSlEvents.builder()
                .id(EVENT_ID)
                .name(NEW_EVENT_NAME)
                .startDate(EVENT_START_DATE)
                .endDate(EVENT_END_DATE)
                .build();
        EventDto editedEventDto = EventDto.builder()
                .id(EVENT_ID)
                .name(NEW_EVENT_NAME)
                .startDate(EVENT_START_DATE)
                .endDate(EVENT_END_DATE)
                .build();

        given(eventRepository.findById(EVENT_ID)).willReturn(Optional.of(existingEvent));
        given(eventRepository.saveAndFlush(editedEvent)).willReturn(editedEvent);

        //when
        EventDto eventDto = eventService.update(editedEventDto);

        //then
        ArgumentCaptor<ErSlEvents> erSlEventsArgumentCaptor = ArgumentCaptor.forClass(ErSlEvents.class);
        verify(eventRepository).saveAndFlush(erSlEventsArgumentCaptor.capture());
        assertThat(erSlEventsArgumentCaptor.getValue().getName()).isEqualTo(NEW_EVENT_NAME);
        assertThat(eventDto).isEqualTo(editedEventDto);
    }

    @Test
    private void checkSavingNewEvent() {
        //given
        ErSlEvents newErSlEvent = ErSlEvents.builder()
                .id(null)
                .name(EVENT_NAME)
                .startDate(EVENT_START_DATE)
                .endDate(EVENT_END_DATE)
                .build();
        EventDto newEventDto = EventDto.builder()
                .id(null)
                .name(EVENT_NAME)
                .startDate(EVENT_START_DATE)
                .endDate(EVENT_END_DATE)
                .build();
        ErSlEvents savedErSlEvent = ErSlEvents.builder()
                .id(EVENT_ID)
                .name(EVENT_NAME)
                .startDate(EVENT_START_DATE)
                .endDate(EVENT_END_DATE)
                .build();
        EventDto savedEventDto = EventDto.builder()
                .id(EVENT_ID)
                .name(EVENT_NAME)
                .startDate(EVENT_START_DATE)
                .endDate(EVENT_END_DATE)
                .build();

        given(eventRepository.saveAndFlush(newErSlEvent)).willReturn(savedErSlEvent);

        //when
        EventDto eventDto = eventService.save(newEventDto);

        //then
        assertThat(eventDto).isEqualTo(savedEventDto);
    }

}
