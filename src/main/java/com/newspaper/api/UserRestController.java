package com.newspaper.api;

import com.newspaper.dto.UserDto;
import com.newspaper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api_user")
public class UserRestController {

     @Autowired
    private UserService userService;

    @GetMapping("/check")
    public UserDto checkDataLogin(@RequestParam String userName, @RequestParam String password){
        return userService.loginCheck(userName,password);
    }

}
