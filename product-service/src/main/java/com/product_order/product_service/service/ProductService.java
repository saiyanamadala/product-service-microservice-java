package com.product_order.product_service.service;

import com.product_order.product_service.model.Product;
import com.product_order.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepo prepo;

    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(prepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addProduct(Product product) {
        prepo.save(product);

        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    public ResponseEntity<Product> getProductById(int id) {
        try {
            Product product = prepo.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>(new Product(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prepo.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<String> putProduct(Product product) {
        Optional<Product> prod = prepo.findById(product.getId());

        if(prod.isPresent()){
            Product p = prod.get();
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setStock(product.getStock());
            prepo.save(p);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteProduct(int id) {
        Optional<Product> prod = prepo.findById(id);

        if(prod.isPresent()){
            prepo.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }
}
