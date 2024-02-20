package com.example.eCommerce.mapper.type;

import com.example.eCommerce.dto.Type.TypeResponse;
import com.example.eCommerce.entities.Type;

import java.util.List;

public interface TypeMapper {
    List<TypeResponse> toDtoS(List<Type> all);
}