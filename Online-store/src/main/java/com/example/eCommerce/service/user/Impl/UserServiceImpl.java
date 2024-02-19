package com.example.eCommerce.service.user.Impl;

import com.example.eCommerce.dto.User.UserRegisterRequest;
import com.example.eCommerce.dto.User.UserRegisterResponse;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.user.UserMapper;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public void register(UserRegisterRequest userRequest) {
        if (userRequest.getEmail().isEmpty())
            throw new NotFoundException("Username can't be empty" , HttpStatus.BAD_GATEWAY);
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setCountry(userRequest.getCountry());
        user.setStreetAddress(userRequest.getStreetAddress());
        user.setTownName(userRequest.getTownName());
        user.setProvinceName(userRequest.getProvinceName());
        user.setZipCode(userRequest.getZipCode());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        user.setAdditionalInfo(userRequest.getAdditionalInfo());
        userRepository.save(user);
    }

    @Override
    public UserRegisterResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("user not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        return userMapper.toDto(user.get());
    }

    @Override
    public void deleteById(Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            System.out.println("user is empty!");
        }
        else {
            userRepository.deleteById(id);
        }
    }

    @Override
    public org.springframework.security.core.userdetails.User findOne(String name) {
        return null;
    }
}
