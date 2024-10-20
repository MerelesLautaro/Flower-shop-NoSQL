package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.FloweringTime;
import com.lautadev.flower_shop.repository.IFloweringTimeRepository;
import com.lautadev.flower_shop.throwable.EntityNotFoundException;
import com.lautadev.flower_shop.util.NullAwareBeanUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloweringTimeService implements IFloweringTimeService{

    @Autowired
    private IFloweringTimeRepository floweringTimeRepository;

    @Override
    public FloweringTime saveFloweringTime(FloweringTime floweringTime) {
        return floweringTimeRepository.save(floweringTime);

        // db.floweringTimes.insertOne({ _id: ObjectId('id'), name: 'nombre del tiempo de floración' });
    }

    @Override
    public List<FloweringTime> getFloweringTimes() {
        return floweringTimeRepository.findAll();

        // db.floweringTimes.find({});
    }

    @Override
    public Optional<FloweringTime> findFloweringTime(ObjectId id) {
        return floweringTimeRepository.findById(id);

        // db.floweringTimes.findOne({ _id: ObjectId('id') });

    }

    @Override
    public void deleteFloweringTime(ObjectId id) {
        floweringTimeRepository.deleteById(id);

        // db.floweringTimes.deleteOne({ _id: ObjectId('id') });
    }

    @Override
    public FloweringTime editFloweringTime(ObjectId id, FloweringTime floweringTime) {
        FloweringTime floweringTimeEdit = floweringTimeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(floweringTime,floweringTimeEdit);

        return this.saveFloweringTime(floweringTimeEdit);

        // db.floweringTimes.updateOne(
        //     { _id: ObjectId('id') },
        //     { $set: { name: 'nombre del tiempo de floración' } }
        // );
    }
}
