package com.newspaper.service.impl;

import com.newspaper.dto.CategoryDto;
import com.newspaper.dto.NewDto;
import com.newspaper.dto.UserDto;
import com.newspaper.entity.Category;
import com.newspaper.entity.User;
import com.newspaper.repository.UserRepository;
import com.newspaper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAll() {
      return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        User oldUser = userRepository.findById(id).orElse(null);
        if (oldUser != null){
            oldUser.setUserName(user.getUserName());
            oldUser.setPassword(user.getPassword());
            oldUser.setEmail(user.getEmail());
            return userRepository.save(oldUser);
        }
        return null;

    }

    @Override
    public void deleteUser_file(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public UserDto loginCheck(String userName, String password) {
        User user = userRepository.findByUsernameAndPassword(userName,password);

        if (user != null){
            return new UserDto(user.getUserName(),user.getPassword(),user.getEmail());
        }else {
            return null;
        }
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

}
