package com.lautadev.flower_shop.repository;

import com.lautadev.flower_shop.model.Flower;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlowerRepository extends MongoRepository<Flower, ObjectId> {

    List<Flower> findByCode(String code);
    // db.flowers.find({ code: 'código' });

    // Cursor
    // db.flowers.find({ code: 'código' }).forEach(doc => { /* procesar cada documento */ });

    List<Flower> findByPrice(double price);
    // db.flowers.find({ price: precio });

    // Cursor
    // db.flowers.find({ price: precio }).forEach(doc => { /* procesar cada documento */ });
}
