package com.example.eCommerce.dto.Cart;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.dto.User.UserRegisterRequest;
import com.example.eCommerce.dto.User.UserRegisterResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {

    private Long cartId;

    private String cartItem;

    private UserRegisterResponse user;

    private List<ProductResponse> products;

    private LocalDateTime createdAt;

}
