package com.product_order.product_service.repository;

import com.product_order.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
