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
@Document(collection = "floweringTimes")
public class FloweringTime {
    @Id
    private ObjectId id;
    private String name;

    // CREATE INDEX ON floweringTimes (name);
    // INSERT INTO floweringTimes (name) VALUES ('nombre del tiempo de floración');
}
