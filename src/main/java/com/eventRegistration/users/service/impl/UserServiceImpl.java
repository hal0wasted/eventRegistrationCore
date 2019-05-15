package com.eventRegistration.users.service.impl;

import com.eventRegistration.entity.ErUsers;
import com.eventRegistration.users.dto.UserDto;
import com.eventRegistration.users.mapper.UserMapper;
import com.eventRegistration.users.repository.UserRepository;
import com.eventRegistration.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDto) {
        ErUsers user = null;

        if (!Objects.isNull(userDto)) {
            Optional<ErUsers> dbUser = userRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(
                    userDto.getName(),
                    userDto.getSurname());
            user = dbUser.orElseGet(() -> userRepository.saveAndFlush(userMapper.dtoToEntity(userDto)));
        }
        return userMapper.entityToDto(user);
    }


}
