package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Season;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ISeasonService {
    public Season saveSeason(Season season);
    public List<Season> getSeasons();
    public Optional<Season> findSeason(ObjectId id);
    public void deleteSeason(ObjectId id);
    public Season editSeason(ObjectId id, Season season);
}
