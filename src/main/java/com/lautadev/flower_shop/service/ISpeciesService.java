package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Species;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ISpeciesService {
    public Species saveSpecies(Species species);
    public List<Species> getSpecies();
    public Optional<Species> findSpecies(ObjectId id);
    public void deleteSpecies(ObjectId id);
    public Species editSpecies(ObjectId id, Species species);
}
