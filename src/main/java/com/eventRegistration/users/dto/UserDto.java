package com.eventRegistration.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotBlank(message = "{error.emptyUserName}")
    private String name;
    @NotBlank(message = "{error.emptySurname}")
    private String surname;
}
