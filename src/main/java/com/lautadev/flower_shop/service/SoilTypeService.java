package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.SoilType;
import com.lautadev.flower_shop.repository.ISoilTypeRepository;
import com.lautadev.flower_shop.throwable.EntityNotFoundException;
import com.lautadev.flower_shop.util.NullAwareBeanUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoilTypeService implements ISoilTypeService{

    @Autowired
    private ISoilTypeRepository soilTypeRepository;

    @Override
    public SoilType saveSoilType(SoilType soilType) {
        return soilTypeRepository.save(soilType);

        // db.soilTypes.insertOne({ _id: ObjectId('id'), name: 'nombre del tipo de suelo' });
    }

    @Override
    public List<SoilType> getSoilTypes() {
        return soilTypeRepository.findAll();

        // db.soilTypes.find({});
    }

    @Override
    public Optional<SoilType> findSoilType(ObjectId id) {
        return soilTypeRepository.findById(id);

        // db.soilTypes.findOne({ _id: ObjectId('id') });
    }

    @Override
    public void deleteSoilType(ObjectId id) {
        soilTypeRepository.deleteById(id);

        // db.soilTypes.deleteOne({ _id: ObjectId('id') });
    }

    @Override
    public SoilType editSoilType(ObjectId id, SoilType soilType) {
        SoilType soilTypeEdit = soilTypeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(soilType,soilTypeEdit);

        return this.saveSoilType(soilTypeEdit);

        // db.soilTypes.updateOne(
        //     { _id: ObjectId('id') },
        //     { $set: { name: 'nombre del tipo de suelo' } }
        // );
    }
}
