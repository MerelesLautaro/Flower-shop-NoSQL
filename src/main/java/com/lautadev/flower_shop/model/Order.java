package com.lautadev.flower_shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private ObjectId id;
    private String num_order;
    private LocalDateTime sellDate;
    private double total;
    @DBRef
    private List<Flower> flowers;


    // CREATE INDEX ON orders (num_order);
    // INSERT INTO orders (num_order, sellDate, total, flowers) VALUES ('número de pedido', fecha_de_venta, total, [ObjectId('id_flower1'), ObjectId('id_flower2')]);
}
