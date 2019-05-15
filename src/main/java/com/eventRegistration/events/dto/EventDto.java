package com.eventRegistration.events.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private Long id;

    @NotBlank(message = "{error.emptyUserName}")
    private String name;

    @NotNull(message = "{error.emptyStartDate}")
    private Date startDate;

    @NotNull(message = "{error.emptyEndDate}")
    @FutureOrPresent(message = "{error.endDateFromPast}")
    private Date endDate;
}
