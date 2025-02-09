package org.example.modelmapperworking.service.impl;

import lombok.AllArgsConstructor;
import org.example.modelmapperworking.entity.User;
import org.example.modelmapperworking.repository.UserRepository;
import org.example.modelmapperworking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return null;
    }

    /*@Override
    public User createUser(User user) {
        user.setFirstName("gulsah");
        user.setLastName("kaplumba");
        return userRepository.save(user);
    }*/
}
