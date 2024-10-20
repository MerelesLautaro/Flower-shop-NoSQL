package com.lautadev.flower_shop.service;

import com.lautadev.flower_shop.model.Season;
import com.lautadev.flower_shop.repository.ISeasonRepository;
import com.lautadev.flower_shop.throwable.EntityNotFoundException;
import com.lautadev.flower_shop.util.NullAwareBeanUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService implements ISeasonService{

    @Autowired
    private ISeasonRepository seasonRepository;

    @Override
    public Season saveSeason(Season season) {
        return seasonRepository.save(season);

        // db.seasons.insertOne({ _id: ObjectId('id'), name: 'nombre de la estación' });
    }

    @Override
    public List<Season> getSeasons() {
        return seasonRepository.findAll();

        // db.seasons.find({});
    }

    @Override
    public Optional<Season> findSeason(ObjectId id) {
        return seasonRepository.findById(id);

        // db.seasons.findOne({ _id: ObjectId('id') });
    }

    @Override
    public void deleteSeason(ObjectId id) {
        seasonRepository.deleteById(id);

        // db.seasons.deleteOne({ _id: ObjectId('id') });
    }

    @Override
    public Season editSeason(ObjectId id, Season season) {
        Season seasonEdit = seasonRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(season,seasonEdit);

        return this.saveSeason(seasonEdit);

        // db.seasons.updateOne(
        //     { _id: ObjectId('id') },
        //     { $set: { name: 'nombre de la estación' } }
        // );
    }
}
