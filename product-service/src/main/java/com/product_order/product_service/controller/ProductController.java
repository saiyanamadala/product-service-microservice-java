package com.product_order.product_service.controller;

import com.product_order.product_service.model.Product;
import com.product_order.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService pserv;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        return pserv.getAllProducts();
    }
}
