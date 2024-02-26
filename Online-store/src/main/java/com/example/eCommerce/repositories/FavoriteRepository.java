package com.example.eCommerce.repositories;

import com.example.eCommerce.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository  extends JpaRepository <Favorite,Long> {
}
