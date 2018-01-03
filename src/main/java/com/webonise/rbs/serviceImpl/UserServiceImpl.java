package com.webonise.rbs.serviceImpl;

import com.webonise.rbs.entity.User;
import com.webonise.rbs.repository.UserRepository;
import com.webonise.rbs.service.UserService;
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
    public List<User> getAllUsers() throws Exception {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error in listing all users.");
            throw ex;
        }
    }

    @Override
    public User findUserById(Long id) throws Exception {
        try {
            return userRepository.findOne(id);
        } catch (Exception ex) {
            System.out.println("Error in finding the user.");
            throw ex;
        }
    }

    @Override
    public User addUser(User user) throws Exception {
        try {
            return userRepository.save(user);
        } catch (Exception ex) {
            System.out.println("Error in adding the user.");
            throw ex;
        }
    }

    @Override
    public User editUser(User user) throws Exception {
        try {
            return userRepository.save(user);
        } catch (Exception ex) {
            System.out.println("Error in editing the user.");
            throw ex;
        }
    }

    @Override
    public Boolean deleteUserById(Long id) throws Exception {
        try {
            User user = userRepository.findOne(id);
            if (user != null) {
                userRepository.delete(user);
                return true;
            }
            return false;
        } catch (Exception ex) {
            System.out.println("Error in deleting the user.");
            throw ex;
        }
    }
}
