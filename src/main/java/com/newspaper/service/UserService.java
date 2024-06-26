package com.newspaper.service;

import com.newspaper.dto.UserDto;

public interface UserService {


    UserDto loginCheck(String userName, String password);

}
