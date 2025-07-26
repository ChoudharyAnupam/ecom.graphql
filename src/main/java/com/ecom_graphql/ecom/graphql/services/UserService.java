package com.ecom_graphql.ecom.graphql.services;

import com.ecom_graphql.ecom.graphql.entities.User;
import com.ecom_graphql.ecom.graphql.helper.ExceptionHelper;
import com.ecom_graphql.ecom.graphql.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createuser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUser(int userId){
        return userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    public boolean deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
