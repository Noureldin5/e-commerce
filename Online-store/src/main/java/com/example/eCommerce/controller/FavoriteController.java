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
    }


