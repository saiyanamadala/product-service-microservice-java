package com.product_order.order_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ElementCollection
    @CollectionTable(name = "trans_product", joinColumns = @JoinColumn(name = "order_id"))
    private List<TransProduct> products;
    private float total;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public List<TransProduct> getProducts() {
        return products;
    }

    public void setProducts(List<TransProduct> products) {
        this.products = products;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
