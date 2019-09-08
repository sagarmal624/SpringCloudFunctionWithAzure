package com.example.hellofunction.functions;

import com.example.hellofunction.domains.User;
import com.example.hellofunction.service.UserService;
import com.example.hellofunction.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class UserFunction {
    @Autowired
    UserService userService;

    @Bean("userSave")
    public Function<User, ResponseDTO> save() {
        return user -> userService.save(user);
    }

    @Bean("userUpdate")
    public Function<User, ResponseDTO> update() {
        return user -> userService.update(user);
    }

    @Bean("userGet")
    public Function<Integer, ResponseDTO> get() {
        return id -> userService.get(id);
    }

    @Bean("userDelete")
    public Function<Integer, ResponseDTO> delete() {
        return id -> userService.delete(id);
    }

    @Bean("userProfile")
    public Function<String, ResponseDTO> userProfile() {
        return id -> userService.userProfile(id);
    }
}
