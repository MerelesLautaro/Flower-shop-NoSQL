package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.SoilType;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ISoilTypeService {
    public SoilType saveSoilType(SoilType soilType);
    public List<SoilType> getSoilTypes();
    public Optional<SoilType> findSoilType(ObjectId id);
    public void deleteSoilType(ObjectId id);
    public SoilType editSoilType(ObjectId id, SoilType soilType);
}
