package com.example.eCommerce.dto.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
    private Long id;
    private String firstName;
    private String lastName;

    private String country;
    private String streetAddress;
    private String townName;
    private String provinceName;
    private Integer ZipCode;
    private Integer phone;
    private String email;
    private String additionalInfo;
}
