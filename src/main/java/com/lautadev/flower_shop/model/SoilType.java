package com.lautadev.flower_shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "soilTypes")
public class SoilType {
    @Id
    private ObjectId id;
    private String name;

    // CREATE INDEX ON soilTypes (name);
    // INSERT INTO soilTypes (name) VALUES ('nombre del tipo de suelo');
}
