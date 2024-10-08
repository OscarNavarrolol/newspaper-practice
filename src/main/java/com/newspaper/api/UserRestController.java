package com.newspaper.api;

import com.newspaper.dto.UserDto;
import com.newspaper.entity.User;
import com.newspaper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api_user")
public class UserRestController {

    @Autowired
    private UserService userService;

    //Crud
    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/get_user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if( user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create_user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.saveUser(user);
        return  new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(name = "id") Long id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null){
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete_user/{id}")
    public  ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/check")
    public User checkDataLogin(@RequestParam String userName, @RequestParam String password){
        return userService.loginCheck(userName,password);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/top_users")
    public ResponseEntity<List<Object[]>> getTopUsers() {
        List<Object[]> topUsers = userService.getTopUsersWithMostNews();
        return new ResponseEntity<>(topUsers, HttpStatus.OK);
    }

}
