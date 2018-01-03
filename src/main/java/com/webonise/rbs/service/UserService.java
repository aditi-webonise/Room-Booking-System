package com.webonise.rbs.service;

import com.webonise.rbs.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws Exception;
    User findUserById(Long id) throws Exception;
    User addUser(User user) throws Exception;
    User editUser(User user) throws Exception;
    Boolean deleteUserById(Long id) throws Exception;
}
