package com.genspark.rest.videocardapi.domain.entity.controller;

import com.genspark.rest.videocardapi.domain.entity.User;
import com.genspark.rest.videocardapi.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/allUsers")
    public List<User> getUsers()
    {
        return userService.get();
    }

    @GetMapping("/userByID/{userID}")
    public User getUserById(@PathVariable String userID)
    {
        return userService.find(Long.parseLong(userID));
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User userToAdd)
    {
        return userService.create(userToAdd);
    }

    @GetMapping("/userByEmail/{email}")
    public User getUserByEmail(@PathVariable String email)
    {
        return userService.findBy(email);
    }


    @PutMapping("/updateUser")
    public User updateUser( @RequestBody User userToUpdate)
    {
        return userService.update(userToUpdate);
    }


    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User userToDelete)
    {
       userService.delete(userToDelete.getId());
    }



}
