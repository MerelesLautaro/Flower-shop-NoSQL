package com.lautadev.flower_shop.repository;

import com.lautadev.flower_shop.model.SoilType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoilTypeRepository extends MongoRepository<SoilType, ObjectId> {
}
