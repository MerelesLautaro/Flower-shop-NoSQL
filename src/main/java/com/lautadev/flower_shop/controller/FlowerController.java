package com.lautadev.flower_shop.controller;

import com.lautadev.flower_shop.model.Flower;
import com.lautadev.flower_shop.service.IFlowerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private IFlowerService flowerService;

    @PostMapping("/save")
    public ResponseEntity<Flower> saveFlower(@RequestBody Flower flower){
        return ResponseEntity.ok(flowerService.saveFlower(flower));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Flower>> getFlowers(){
        return ResponseEntity.ok(flowerService.getFlowers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Flower> findFlower(@PathVariable ObjectId id){
        Optional<Flower> flower = flowerService.findFlower(id);
        return flower.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlower(@PathVariable ObjectId id){
        flowerService.deleteFlower(id);
        return ResponseEntity.ok("Flower deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Flower> editFlower(@PathVariable ObjectId id, @RequestBody Flower flower){
        return ResponseEntity.ok(flowerService.editFlower(id,flower));
    }
}
