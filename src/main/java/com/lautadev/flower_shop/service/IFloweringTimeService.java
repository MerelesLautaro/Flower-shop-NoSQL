package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.FloweringTime;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IFloweringTimeService {
    public FloweringTime saveFloweringTime(FloweringTime floweringTime);
    public List<FloweringTime> getFloweringTimes();
    public Optional<FloweringTime> findFloweringTime(ObjectId id);
    public void deleteFloweringTime(ObjectId id);
    public FloweringTime editFloweringTime(ObjectId id, FloweringTime floweringTime);
}
