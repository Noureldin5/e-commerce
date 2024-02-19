package com.example.eCommerce.service.order.Impl;

import com.example.eCommerce.entities.Order;
import com.example.eCommerce.repositories.OrderRepository;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

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