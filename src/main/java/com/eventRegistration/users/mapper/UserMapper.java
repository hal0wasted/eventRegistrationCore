package com.eventRegistration.users.mapper;

import com.eventRegistration.entity.ErUsers;
import com.eventRegistration.users.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto entityToDto(ErUsers erUsers);

    ErUsers dtoToEntity(UserDto userDto);

}
