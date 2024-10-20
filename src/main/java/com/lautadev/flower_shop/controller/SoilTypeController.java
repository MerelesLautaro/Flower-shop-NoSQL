package com.lautadev.flower_shop.controller;

import com.lautadev.flower_shop.model.SoilType;
import com.lautadev.flower_shop.service.ISoilTypeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/soil-type")
public class SoilTypeController {

    @Autowired
    private ISoilTypeService soilTypeService;

    @PostMapping("/save")
    public ResponseEntity<SoilType> saveSoilType(@RequestBody SoilType soilType){
        return ResponseEntity.ok(soilTypeService.saveSoilType(soilType));
    }

    @GetMapping("/get")
    public ResponseEntity<List<SoilType>> getSoilTypes(){
        return ResponseEntity.ok(soilTypeService.getSoilTypes());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SoilType> findSoilType(@PathVariable ObjectId id){
        Optional<SoilType> soilType = soilTypeService.findSoilType(id);
        return soilType.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSoilType(@PathVariable ObjectId id){
        soilTypeService.deleteSoilType(id);
        return ResponseEntity.ok("Soil Type deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<SoilType> editSoilType(@PathVariable ObjectId id, @RequestBody SoilType soilType){
        return ResponseEntity.ok(soilTypeService.editSoilType(id,soilType));
    }

}
