package com.newspaper.service;

import com.newspaper.dto.UserDto;
import com.newspaper.entity.User;

public interface UserService {


    UserDto loginCheck(String userName, String password);

    User registerUser(User user);

}
