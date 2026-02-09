package com.example.exp_tra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exp_tra.service.userService;
import com.example.exp_tra.user_entity.userEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
public class controller {

    @Autowired
    private userService userService;

    @GetMapping
    public List<userEntity> getAll() {
        return userService.getAll();
    }
    
    @PostMapping
    public boolean saveUser(@RequestBody userEntity user) {
        userService.saveUser(user);
        return true;
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable long id, @RequestBody userEntity user){

        userEntity old = userService.getUserById(id);
         if (old != null) {
            old.setName(user.getName() != null && !user.getName().isEmpty() ? user.getName() : old.getName());
            old.setEmail(user.getEmail() != null && !user.getEmail().isEmpty() ? user.getEmail() : old.getEmail());
            userService.saveUser(old);
            return true;
        }
        return false;
    }

    @GetMapping("/{id}")
    public userEntity getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable long id) {
        userEntity user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
            return true;
        }
        return false;
    }


}
