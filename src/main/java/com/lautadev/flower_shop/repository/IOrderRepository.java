package com.lautadev.flower_shop.repository;

import com.lautadev.flower_shop.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends MongoRepository<Order, ObjectId> {
}
