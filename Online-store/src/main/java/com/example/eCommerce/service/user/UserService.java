package com.example.eCommerce.service.user;

import com.example.eCommerce.dto.User.UserRegisterRequest;
import com.example.eCommerce.dto.User.UserRegisterResponse;

public interface UserService {
    void register(UserRegisterRequest userRequest);
    UserRegisterResponse getById(Long id);
    void deleteById(Long id);
}
