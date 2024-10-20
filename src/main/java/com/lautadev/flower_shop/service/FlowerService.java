package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Flower;
import com.lautadev.flower_shop.repository.IFlowerRepository;
import com.lautadev.flower_shop.throwable.EntityNotFoundException;
import com.lautadev.flower_shop.util.NullAwareBeanUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService implements IFlowerService{

    @Autowired
    private IFlowerRepository flowerRepository;

    @Override
    public Flower saveFlower(Flower flower) {
        return flowerRepository.save(flower);

        // db.flowers.insertOne({ _id: ObjectId('id'), code: 'code', price: precio, species: ObjectId('id_especie') });
    }

    @Override
    public List<Flower> getFlowers() {
        return flowerRepository.findAll();

        // db.flowers.find({});
    }

    @Override
    public Optional<Flower> findFlower(ObjectId id) {
        return flowerRepository.findById(id);

        // db.flowers.findOne({ _id: ObjectId('id') });

    }

    @Override
    public void deleteFlower(ObjectId id) {
        flowerRepository.deleteById(id);

        // db.flowers.deleteOne({ _id: ObjectId('id') });
    }

    @Override
    public Flower editFlower(ObjectId id, Flower flower) {
        Flower flowerEdit = flowerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(flower,flowerEdit);

        return this.saveFlower(flowerEdit);

        // db.flowers.updateOne(
        //     { _id: ObjectId('id') },
        //     { $set: { code: 'code', price: precio, species: ObjectId('id_especie') } }
        // );
    }

    @Override
    public List<Flower> findByCode(String code) {
        return flowerRepository.findByCode(code);

        // db.flowers.find({ code: 'código' });
    }

    @Override
    public List<Flower> findByPrice(double price) {
        return flowerRepository.findByPrice(price);

        // db.flowers.find({ price: precio });
    }
}
