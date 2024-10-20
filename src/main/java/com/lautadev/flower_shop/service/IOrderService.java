package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Order;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    public Order saveOrder(Order order);
    public List<Order> getOrders();
    public Optional<Order> findOrder(ObjectId id);
    public void deleteOrder(ObjectId id);
    public Order editOrder(ObjectId id, Order order);
}
