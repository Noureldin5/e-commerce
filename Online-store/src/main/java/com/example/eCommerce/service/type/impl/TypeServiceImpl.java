package com.example.eCommerce.service.type.impl;

import com.example.eCommerce.dto.Type.TypeResponse;
import com.example.eCommerce.entities.Type;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.type.TypeMapper;
import com.example.eCommerce.repositories.TypeRepository;
import com.example.eCommerce.service.type.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeMapper typeMapper;
    private final TypeRepository typeRepository;
    @Override
    public void addType(String name, String token) {
        if (typeRepository.findByName(name).isPresent())
            throw new NotFoundException("type with name: "+name+" is already exist!", HttpStatus.BAD_REQUEST);
        Type type = new Type();
        type.setTypeName(name);
        typeRepository.save(type);
    }

    @Override
    public List<TypeResponse> getAll() {
        return typeMapper.toDtoS(typeRepository.findAll());
    }
}