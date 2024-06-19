package com.newspaper.service.impl;

import com.newspaper.dto.CategoryDto;
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

}
