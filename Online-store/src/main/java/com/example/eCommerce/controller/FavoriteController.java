package com.example.eCommerce.controller;

import com.example.eCommerce.entities.Favorite;
import com.example.eCommerce.entities.Review;
import com.example.eCommerce.service.favorite.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {


    private FavoriteService favoriteService;


    @PostMapping
    public Review addFavorite(@RequestBody Favorite favorite) {
        return favoriteService.createFavorite(favorite);
    }

    @GetMapping("/product/{productId}")
    public List<Favorite> getFavoritesByProductId(@PathVariable Long productId) {
        return favoriteService.getFavoritesByProductId(productId);
    }

    @PutMapping
    public String UpdateFavorite(@PathVariable Long favoriteId, @RequestBody com.example.eCommerce.dto.Favorite.FavoriteRequest favoriteRequest,
                                 @RequestHeader("Authorization") String token) {
        favoriteService.update(favoriteId, favoriteRequest, token);
        return "Review was updated successfully!";
    }
    @DeleteMapping
    public String deleteReview(@PathVariable Long favoriteId, @RequestHeader("Authorization") String token){
        favoriteService.deleteFavorite(favoriteId, token );
        return "fav  was deleted successfully!";

    }
}


