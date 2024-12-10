package com.product_order.product_service.service;

import com.product_order.product_service.model.Product;
import com.product_order.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductRepo prepo;

    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(prepo.findAll(), HttpStatus.OK);
    }
}
