package com.lautadev.flower_shop.controller;

import com.lautadev.flower_shop.model.Season;
import com.lautadev.flower_shop.service.ISeasonService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/season")
public class SeasonController {

    @Autowired
    private ISeasonService seasonService;

    @PostMapping("/save")
    public ResponseEntity<Season> saveSeason(@RequestBody Season season){
        return ResponseEntity.ok(seasonService.saveSeason(season));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Season>> getSeasons(){
        return ResponseEntity.ok(seasonService.getSeasons());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Season> findSeason(@PathVariable ObjectId id){
        Optional<Season> season = seasonService.findSeason(id);
        return season.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSeason(@PathVariable ObjectId id){
        seasonService.deleteSeason(id);
        return ResponseEntity.ok("Season deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Season> editSeason(@PathVariable ObjectId id, @RequestBody Season season){
        return ResponseEntity.ok(seasonService.editSeason(id,season));
    }


}
