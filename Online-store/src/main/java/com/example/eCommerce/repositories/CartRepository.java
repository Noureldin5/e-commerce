package com.example.eCommerce.repositories;

import com.example.eCommerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository <Cart,Long> {
}
