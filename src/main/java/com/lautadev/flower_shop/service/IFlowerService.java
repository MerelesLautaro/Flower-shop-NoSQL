package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Flower;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IFlowerService {
    public Flower saveFlower(Flower flower);
    public List<Flower> getFlowers();
    public Optional<Flower> findFlower(ObjectId id);
    public void deleteFlower(ObjectId id);
    public Flower editFlower(ObjectId id, Flower flower);
    public List<Flower> findByCode(String code);
    public List<Flower> findByPrice(double price);
}
