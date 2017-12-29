package com.webonise.rbs.service;

import com.webonise.rbs.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User findUserById(Long id);
    User addUser(User user);
    User editUser(User user);
    Boolean deleteUserById(Long id);
}
