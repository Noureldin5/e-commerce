package com.example.eCommerce.mapper.user;

import com.example.eCommerce.dto.User.UserRegisterResponse;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.mapper.user.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserRegisterResponse toDto(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setId(user.getId());
        userRegisterResponse.setFirstName(user.getFirstName());
        userRegisterResponse.setLastName(user.getLastName());
        userRegisterResponse.setEmail(user.getEmail());
        userRegisterResponse.setCountry(user.getCountry());
        userRegisterResponse.setPhone(user.getPhone());
        userRegisterResponse.setProvinceName(user.getProvinceName());
        userRegisterResponse.setStreetAddress(user.getStreetAddress());
        userRegisterResponse.setTownName(user.getTownName());
        userRegisterResponse.setZipCode(user.getZipCode());
        userRegisterResponse.setAdditionalInfo(user.getAdditionalInfo());
        return userRegisterResponse;




    }
}
