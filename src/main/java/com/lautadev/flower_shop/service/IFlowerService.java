package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Flower;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IFlowerService {
    Flower saveFlower(Flower flower);
    List<Flower> getFlowers();
    Optional<Flower> findFlower(ObjectId id);
    void deleteFlower(ObjectId id);
    Flower editFlower(ObjectId id, Flower flower);
}
