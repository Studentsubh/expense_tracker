package com.example.exp_tra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exp_tra.repo.userRepository;
import com.example.exp_tra.user_entity.userEntity;

@Service
public class userService {

    @Autowired
    private userRepository repo;

    public List<userEntity> getAll(){
        return repo.findAll();
    }

    public userEntity saveUser(userEntity user){
        return repo.save(user);
    }

    public userEntity update(userEntity user){
        return repo.save(user);
    }

    public userEntity getUserById(long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteUser(long id) {
        repo.deleteById(id);
    }
}
//8670656139
