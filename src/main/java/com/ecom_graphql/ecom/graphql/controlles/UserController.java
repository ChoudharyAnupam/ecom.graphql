package com.ecom_graphql.ecom.graphql.controlles;

import com.ecom_graphql.ecom.graphql.entities.User;
import com.ecom_graphql.ecom.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);

        return userService.createuser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @QueryMapping
    public User getUser(@Argument int userId) {
        return userService.getUser(userId);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }

}
