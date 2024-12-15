package com.product_order.order_service.Dao;

import com.product_order.order_service.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Orders,Integer> {
}
