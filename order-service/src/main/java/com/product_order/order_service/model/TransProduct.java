package com.product_order.order_service.model;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class TransProduct {

    private int productID;
    private int quantity;
    private float price;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
