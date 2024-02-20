package com.example.eCommerce.service.type;

import com.example.eCommerce.dto.Type.TypeResponse;

import java.util.List;

public interface TypeService {
    void addType(String name, String token);

    List<TypeResponse> getAll();
}