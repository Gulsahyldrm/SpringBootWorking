package org.example.serversidepagination.service;


import org.example.serversidepagination.dto.UserDto;
import org.example.serversidepagination.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    UserDto createUser (UserDto user);

    List<UserDto> getUsers();

    UserDto getUser (Long id);

    UserDto updateUser(Long id, UserDto user);

    Boolean deleteUser(Long id);

    Page <User> pagination( int currentPage, int pageSize);
}
