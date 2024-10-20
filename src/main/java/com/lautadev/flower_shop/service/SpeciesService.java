package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Species;
import com.lautadev.flower_shop.repository.ISpeciesRepository;
import com.lautadev.flower_shop.throwable.EntityNotFoundException;
import com.lautadev.flower_shop.util.NullAwareBeanUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService implements ISpeciesService {

    @Autowired
    private ISpeciesRepository speciesRepository;

    @Override
    public Species saveSpecies(Species species) {
        return speciesRepository.save(species);

        // db.species.insertOne({ _id: ObjectId('id'), name: 'nombre de la especie', exposureTime: tiempo_exposición, floweringTimes: [ObjectId('id_tiempo_floracion')], soilTypes: [ObjectId('id_tipo_suelo')], seasons: [ObjectId('id_estacion')] });
    }

    @Override
    public List<Species> getSpecies() {
        return speciesRepository.findAll();

        // db.species.find({});
    }

    @Override
    public Optional<Species> findSpecies(ObjectId id) {
        return speciesRepository.findById(id);

        // db.species.findOne({ _id: ObjectId('id') });
    }

    @Override
    public void deleteSpecies(ObjectId id) {
        speciesRepository.deleteById(id);

        // db.species.deleteOne({ _id: ObjectId('id') });
    }

    @Override
    public Species editSpecies(ObjectId id, Species species) {
        Species speciesEdit = speciesRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(species,speciesEdit);

        return this.saveSpecies(speciesEdit);

        // db.species.updateOne(
        //     { _id: ObjectId('id') },
        //     { $set: { name: 'nombre de la especie', exposureTime: tiempo_exposición, floweringTimes: [ObjectId('id_tiempo_floracion')], soilTypes: [ObjectId('id_tipo_suelo')], seasons: [ObjectId('id_estacion')] } }
        // );
    }

    @Override
    public List<Species> findByName(String name) {
        return speciesRepository.findByName(name);

        // db.species.find({ name: 'nombre' });
    }

    @Override
    public List<Species> findByExposureTime(double exposureTime) {
        return speciesRepository.findByExposureTime(exposureTime);

        // db.species.find({ exposureTime: tiempo_de_exposición });
    }
}
