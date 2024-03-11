package com.example.eCommerce.mapper.favorite;

import com.example.eCommerce.dto.Favorite.FavoriteResponse;
import com.example.eCommerce.entities.Favorite;

import java.util.ArrayList;
import java.util.List;

public class FavoriteMapperImpl implements FavoriteMapper{
    @Override
    public com.example.eCommerce.dto.Favorite.FavoriteResponse toDto(Favorite favorite) {
        com.example.eCommerce.dto.Favorite.FavoriteResponse favoriteResponse = new com.example.eCommerce.dto.Favorite.FavoriteResponse();
        favoriteResponse.setId(favorite.getFavoriteId());
        return favoriteResponse;
    }

    @Override
    public List<FavoriteResponse> toDtoS(List<Favorite> all) {
        return null;
    }

    @Override
    public List<com.example.eCommerce.dto.Favorite.FavoriteResponse> toDtos(List<Favorite> favorites) {
        List<com.example.eCommerce.dto.Favorite.FavoriteResponse> favoriteResponses = new ArrayList<>();
        for(Favorite favorite : favorites){
            favoriteResponses.add(toDto(favorite));
        }
        return favoriteResponses;
    }
}


