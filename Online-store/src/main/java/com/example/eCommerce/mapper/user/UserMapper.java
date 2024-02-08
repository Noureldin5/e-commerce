package com.example.eCommerce.mapper.user;

import com.example.eCommerce.dto.User.UserRegisterResponse;
import com.example.eCommerce.entities.User;

public interface UserMapper {
    UserRegisterResponse toDto(User user);
}
