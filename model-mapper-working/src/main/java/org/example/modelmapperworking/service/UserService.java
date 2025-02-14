package org.example.modelmapperworking.service;

import org.example.modelmapperworking.entity.User;

import java.util.List;

public interface UserService {

    User createUser (User user);

    List<User> getUsers();

    User getUser (Long id);

    User updateUser(Long id, User user);

    User deleteUser(User user);
}
