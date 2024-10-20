package com.lautadev.flower_shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "species")
public class Species {
    @Id
    private ObjectId id;
    private String name;
    private double exposureTime;
    @DBRef
    private List<FloweringTime> floweringTimes;
    @DBRef
    private List<SoilType> soilTypes;
    @DBRef
    private List<Season> seasons;

    // CREATE INDEX ON species (name);
    // INSERT INTO species (name, exposureTime, floweringTimes, soilTypes, seasons) VALUES ('nombre', tiempo_de_exposición,
    // [ObjectId('id_floweringTime1'), ObjectId('id_floweringTime2')], [ObjectId('id_soilType1')], [ObjectId('id_season1')]);
}
