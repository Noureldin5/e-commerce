package com.example.eCommerce.mapper.favorite;

import com.example.eCommerce.dto.Favorite.FavoriteResponse;
import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.entities.Product;

import java.util.List;

public interface FavoriteMapper {
    FavoriteResponse toDto(Favorite favorite);

    List<FavoriteResponse> toDtoS(List<Favorite> all);

    List<FavoriteResponse> toDtos(List<Favorite> favorites);
}
