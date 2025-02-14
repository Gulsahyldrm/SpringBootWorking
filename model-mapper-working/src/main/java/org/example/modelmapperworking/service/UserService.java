package org.example.modelmapperworking.service;

import org.example.modelmapperworking.dto.UserDto;
import org.example.modelmapperworking.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser (UserDto user);

    List<UserDto> getUsers();

    UserDto getUser (Long id);

    UserDto updateUser(Long id, UserDto user);

    Boolean deleteUser(Long id);
}
