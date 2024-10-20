package com.lautadev.flower_shop.controller;

import com.lautadev.flower_shop.model.Species;
import com.lautadev.flower_shop.service.ISpeciesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private ISpeciesService speciesService;

    @PostMapping("/save")
    public ResponseEntity<Species> saveSpecies(@RequestBody Species species){
        return ResponseEntity.ok(speciesService.saveSpecies(species));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Species>> getSpecies(){
        return ResponseEntity.ok(speciesService.getSpecies());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Species> findSpecies(@PathVariable ObjectId id){
        Optional<Species> species = speciesService.findSpecies(id);
        return species.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<List<Species>> findByName(@PathVariable String name){
        return ResponseEntity.ok(speciesService.findByName(name));
    }

    @GetMapping("/get/findByExposureTime")
    public ResponseEntity<List<Species>> findByExposureTime(@RequestParam double exposureTime){
        return ResponseEntity.ok(speciesService.findByExposureTime(exposureTime));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSpecies(@PathVariable ObjectId id){
        speciesService.deleteSpecies(id);
        return ResponseEntity.ok("Species deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Species> editSpecies(@PathVariable ObjectId id, @RequestBody Species species){
        return ResponseEntity.ok(speciesService.editSpecies(id,species));
    }


}
