package com.example.eCommerce.service.favorite;

import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.entities.Review;

import java.util.List;

public interface FavoriteService {
    Review createFavorite(Favorite favorite);

    List<Favorite> getFavoritesByProductId(Long productId);
}
