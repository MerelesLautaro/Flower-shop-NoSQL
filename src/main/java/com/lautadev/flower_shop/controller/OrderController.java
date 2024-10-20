package com.lautadev.flower_shop.controller;

import com.lautadev.flower_shop.model.Order;
import com.lautadev.flower_shop.service.IOrderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Order> findOrder(@PathVariable ObjectId id){
        Optional<Order> order = orderService.findOrder(id);
        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable ObjectId id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Order> editOrder(@PathVariable ObjectId id, @RequestBody Order order){
        return ResponseEntity.ok(orderService.editOrder(id,order));
    }

}
