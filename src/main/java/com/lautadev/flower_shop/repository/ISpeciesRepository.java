package com.lautadev.flower_shop.repository;

import com.lautadev.flower_shop.model.Species;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISpeciesRepository extends MongoRepository<Species, ObjectId> {

    List<Species> findByName(String name);
    // db.species.find({ name: 'nombre' });

    // Cursor
    // db.species.find({ name: 'nombre' }).forEach(doc => { /* procesar cada documento */ });

    List<Species> findByExposureTime(double exposureTime);
    // db.species.find({ exposureTime: tiempo_de_exposición });

    // Cursor
    // db.species.find({ exposureTime: tiempo_de_exposición }).forEach(doc => { /* procesar cada documento */ });
}
