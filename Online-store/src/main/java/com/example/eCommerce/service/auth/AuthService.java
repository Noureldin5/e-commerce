package com.example.eCommerce.service.auth;

import com.example.eCommerce.dto.AuthLogin.AuthLoginRequest;
import com.example.eCommerce.dto.AuthLogin.AuthLoginResponse;
import com.example.eCommerce.dto.User.UserRegisterRequest;
import com.example.eCommerce.entities.User;
import org.springframework.stereotype.Service;

public interface AuthService {
    void register(UserRegisterRequest userRegisterRequest);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);

    User getUsernameFromToken(String token);
}
