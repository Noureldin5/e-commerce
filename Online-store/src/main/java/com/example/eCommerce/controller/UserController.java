package com.example.eCommerce.controller;

import com.example.eCommerce.dto.User.UserRegisterRequest;
import com.example.eCommerce.dto.User.UserRegisterResponse;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.user.UserService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    @PostMapping("/register")
    public void register(@RequestBody UserRegisterRequest userRequest){
        userService.register(userRequest);
    }
    @GetMapping("/{id}")
    public UserRegisterResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        userService.deleteById(id);

    }
}
