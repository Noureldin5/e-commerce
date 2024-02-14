package com.example.eCommerce.service.order;

import com.example.eCommerce.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface OrderService {
    Page<Order> findByBuyerEmail(String name, PageRequest request);

    Page<Order> findAll(PageRequest request);

    Order findOne(Long orderId);

    Order cancel(Long orderId);

    Order finish(Long orderId);
}
