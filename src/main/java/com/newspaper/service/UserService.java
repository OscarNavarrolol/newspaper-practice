package com.newspaper.service;

import com.newspaper.dto.UserDto;
import com.newspaper.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User saveUser(User user);

    public User getUserById(Long id);

    public User updateUser(Long id, User user);

    public void deleteUser(long id);

    UserDto loginCheck(String userName, String password);

    User registerUser(User user);

    public List<User> getTopUsersWithMostNews();
}
