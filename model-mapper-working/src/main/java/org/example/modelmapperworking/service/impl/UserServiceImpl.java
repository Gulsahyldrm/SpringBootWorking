package org.example.modelmapperworking.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.modelmapperworking.dto.UserDto;
import org.example.modelmapperworking.entity.User;
import org.example.modelmapperworking.repository.UserRepository;
import org.example.modelmapperworking.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> userResult = userRepository.findById(id);
        if (userResult.isPresent()) {
            userResult.get().setFirstName(user.getFirstName());
            userResult.get().setLastName(user.getLastName());


            return modelMapper.map(userRepository.save(userResult.get()), UserDto.class);
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> userResult = userRepository.findById(id);
        if (userResult.isPresent()) {
            userRepository.deleteById(id);
            return  true;
        }
        return false;
    }
}
