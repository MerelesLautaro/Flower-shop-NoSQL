package com.lautadev.flower_shop.controller;

import com.lautadev.flower_shop.model.FloweringTime;
import com.lautadev.flower_shop.service.IFloweringTimeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flowering-time")
public class FloweringTImeController {

    @Autowired
    private IFloweringTimeService floweringTimeService;

    @PostMapping("/save")
    public ResponseEntity<FloweringTime> saveFloweringTime(@RequestBody FloweringTime floweringTime){
        return ResponseEntity.ok(floweringTimeService.saveFloweringTime(floweringTime));
    }

    @GetMapping("/get")
    public ResponseEntity<List<FloweringTime>> getFloweringTimes(){
        return ResponseEntity.ok(floweringTimeService.getFloweringTimes());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FloweringTime> findFloweringTime(@PathVariable ObjectId id){
        Optional<FloweringTime> floweringTime = floweringTimeService.findFloweringTime(id);
        return floweringTime.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFloweringTime(@PathVariable ObjectId id){
        floweringTimeService.deleteFloweringTime(id);
        return ResponseEntity.ok("Flowering Time deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<FloweringTime> editFloweringTime(@PathVariable ObjectId id, @RequestBody FloweringTime floweringTime){
        return ResponseEntity.ok(floweringTimeService.editFloweringTime(id,floweringTime));
    }

}
