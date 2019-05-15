package com.eventRegistration.eventRegistration.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRegistrationDto {

    private Long id;
    @NotNull(message = "{error.emptyEventId}")
    private Long eventId;
    @NotNull(message = "{error.emptyUserId}")
    private Long userId;
}
