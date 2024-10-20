package com.lautadev.flower_shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "flowers")
public class Flower {
    @Id
    private ObjectId id;
    private String code;
    private double price;
    @DBRef
    private Species species;

    // CREATE INDEX ON flowers (code);
    // INSERT INTO flowers (code, price, species) VALUES ('código', precio, ObjectId('id_especie'));
}
