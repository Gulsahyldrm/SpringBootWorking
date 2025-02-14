package org.example.modelmapperworking.service.impl;

import lombok.AllArgsConstructor;
import org.example.modelmapperworking.entity.User;
import org.example.modelmapperworking.repository.UserRepository;
import org.example.modelmapperworking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userResult = userRepository.findById(id);
        if (userResult.isPresent()) {
            userResult.get().setFirstName(user.getFirstName());
            userResult.get().setLastName(user.getLastName());


            return userRepository.save(userResult.get());
        }
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }
}
