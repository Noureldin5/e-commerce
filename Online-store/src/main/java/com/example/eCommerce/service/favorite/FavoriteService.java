package com.example.eCommerce.service.favorite;

import com.example.eCommerce.dto.Favorite.FavoriteRequest;
import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.entities.Review;

import java.util.List;

public interface FavoriteService {
    Review createFavorite(Favorite favorite);

    List<Favorite> getFavoritesByProductId(Long productId);

    void update(Long favoriteId, FavoriteRequest favoriteRequest, String token);

    void deleteFavorite(Long favoriteId, String token);
}
