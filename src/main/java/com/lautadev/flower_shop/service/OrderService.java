package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Order;
import com.lautadev.flower_shop.repository.IOrderRepository;
import com.lautadev.flower_shop.throwable.EntityNotFoundException;
import com.lautadev.flower_shop.util.NullAwareBeanUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);

        // db.orders.insertOne({ _id: ObjectId('id'), num_order: 'número de pedido', sellDate: ISODate('fecha'), total: total, flowers: [ObjectId('id_flower1'), ObjectId('id_flower2')] });
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();

        // db.orders.find({});
    }

    @Override
    public Optional<Order> findOrder(ObjectId id) {
        return orderRepository.findById(id);

        // db.orders.findOne({ _id: ObjectId('id') });
    }

    @Override
    public void deleteOrder(ObjectId id) {
        orderRepository.deleteById(id);

        // db.orders.deleteOne({ _id: ObjectId('id') });
    }

    @Override
    public Order editOrder(ObjectId id, Order order) {
        Order orderEdit = orderRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(order,orderEdit);

        return this.saveOrder(orderEdit);

        // db.orders.updateOne(
        //     { _id: ObjectId('id') },
        //     { $set: { num_order: 'número de pedido', sellDate: ISODate('fecha'), total: total, flowers: [ObjectId('id_flower1'), ObjectId('id_flower2')] } }
        // );
    }
}
