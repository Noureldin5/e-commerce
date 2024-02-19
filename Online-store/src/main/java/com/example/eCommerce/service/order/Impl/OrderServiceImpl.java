package com.example.eCommerce.service.order.Impl;

import com.example.eCommerce.entities.Order;
import com.example.eCommerce.service.order.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class OrderServiceImpl implements OrderService {

    @Override
    public Page<Order> findByBuyerEmail(String name, PageRequest request) {
        return null;
    }

    @Override
    public Page<Order> findAll(PageRequest request) {
        return null;
    }

    @Override
    public Order findOne(Long orderId) {
        return null;
    }

    @Override
    public Order cancel(Long orderId) {
        return null;
    }

    @Override
    public Order finish(Long orderId) {
        return null;
    }
}