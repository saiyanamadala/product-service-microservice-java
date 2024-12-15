package com.product_order.order_service.productInterface;

import com.product_order.order_service.model.Product;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PRODUCT-SERVICE")
public interface ProductInterface {

    @GetMapping("product/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id);

    @PutMapping("product/put")
    public ResponseEntity<String> putProduct(@RequestBody Product product);
}
