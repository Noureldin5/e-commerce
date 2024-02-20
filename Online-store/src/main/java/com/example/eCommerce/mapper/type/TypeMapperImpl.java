package com.example.eCommerce.mapper.type;

import com.example.eCommerce.dto.Type.TypeResponse;
import com.example.eCommerce.entities.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeMapperImpl implements TypeMapper {
    @Override
    public List<TypeResponse> toDtoS(List<Type> all) {
        List<TypeResponse> typeResponses = new ArrayList<>();
        for (Type type: all){
            typeResponses.add(toDto(type));
        }
        return typeResponses;
    }

    private TypeResponse toDto(Type type) {
        TypeResponse typeResponse = new TypeResponse();
        typeResponse.setId(type.getId());
        typeResponse.setName(type.getTypeName());
        return typeResponse;
    }
}
