package com.eventRegistration.service;

import com.eventRegistration.entity.ErUsers;
import com.eventRegistration.users.dto.UserDto;
import com.eventRegistration.users.mapper.UserMapper;
import com.eventRegistration.users.repository.UserRepository;
import com.eventRegistration.users.service.impl.UserServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceImplTest {

    private static final Long USER_ID = 1L;
    private static final String USER_NAME = "UserName";
    private static final String USER_SURNAME = "UserSurname";

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
    }

    @Test
    void checkSavingNewUser() {
        //given
        UserDto newUserDto = UserDto.builder()
                .id(null)
                .name(USER_NAME)
                .surname(USER_SURNAME)
                .build();
        ErUsers newUserEntity = ErUsers.builder()
                .id(null)
                .name(USER_NAME)
                .surname(USER_SURNAME)
                .build();
        UserDto savedUserDto = UserDto.builder()
                .id(USER_ID)
                .name(USER_NAME)
                .surname(USER_SURNAME)
                .build();
        ErUsers savedUserEntity = ErUsers.builder()
                .id(USER_ID)
                .name(USER_NAME)
                .surname(USER_SURNAME)
                .build();

        given(userRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(USER_NAME, USER_SURNAME)).willReturn(null);
        given(userRepository.saveAndFlush(newUserEntity)).willReturn(savedUserEntity);

        given(userMapper.dtoToEntity(newUserDto)).willReturn(newUserEntity);
        given(userMapper.entityToDto(savedUserEntity)).willReturn(savedUserDto);

        //when
        UserDto user = userService.save(newUserDto);

        //then
        assertThat(user).isEqualTo(savedUserDto);
    }
}
