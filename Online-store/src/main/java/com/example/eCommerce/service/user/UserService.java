package com.example.eCommerce.service.user;

import com.example.eCommerce.dto.User.UserRegisterRequest;
import com.example.eCommerce.dto.User.UserRegisterResponse;
import org.springframework.security.core.userdetails.User;

public interface UserService {
    void register(UserRegisterRequest userRequest);
    UserRegisterResponse getById(Long id);
    void deleteById(Long id);

    User findOne(String name);
}
