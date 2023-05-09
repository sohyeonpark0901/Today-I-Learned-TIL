package com.example.ordersmicroservice.service;

import com.example.ordersmicroservice.dto.OrderDto;
import com.example.ordersmicroservice.repository.OrderEntity;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
