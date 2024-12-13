package com.product_order.product_service.controller;

import com.product_order.product_service.model.Product;
import com.product_order.product_service.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService pserv;

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        return pserv.getAllProducts();
    }

    @PostMapping("addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        return pserv.addProduct(product);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return pserv.getProductById(id);
    }

    @PutMapping("put")
    public ResponseEntity<String> putProduct(@RequestBody Product product){
        return pserv.putProduct(product);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        return pserv.deleteProduct(id);
    }
}
