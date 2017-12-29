package com.webonise.rbs.service;

import com.webonise.rbs.entity.User;
import com.webonise.rbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        User user = userRepository.findOne(id);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
