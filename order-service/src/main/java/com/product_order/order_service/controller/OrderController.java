package com.product_order.order_service.controller;

import com.product_order.order_service.model.Orders;
import com.product_order.order_service.model.TransProduct;
import com.product_order.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService oserv;

    @GetMapping("all")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return oserv.getAllProducts();
    }

    @PostMapping("check")
    public ResponseEntity<?> checkOrder(@RequestBody List<TransProduct> basket){
        return oserv.checkOrder(basket);
    }

    @PostMapping("submit")
    public ResponseEntity<String> submitOrder(@RequestBody List<TransProduct> basket){
        return oserv.submitOrder(basket);
    }
}
