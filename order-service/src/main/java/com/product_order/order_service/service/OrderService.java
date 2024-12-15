package com.product_order.order_service.service;

import com.product_order.order_service.Dao.OrderDao;
import com.product_order.order_service.model.Orders;
import com.product_order.order_service.model.Product;
import com.product_order.order_service.model.TransProduct;
import com.product_order.order_service.productInterface.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao odao;

    @Autowired
    ProductInterface pinf;

    public ResponseEntity<List<Orders>> getAllProducts() {
        return new ResponseEntity<>(odao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> checkOrder(List<TransProduct> basket) {
        float total =0;
        int k=0;
        for(TransProduct req: basket){

            Product prod = pinf.getProductById(req.getProductID()).getBody();

            if(req.getQuantity()<=prod.getStock()){
                total+=(req.getQuantity()*req.getPrice());
            }
            else{
                k=1;
            }
        }

        if(k==0){
            return new ResponseEntity<>(total,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not all items are in stock", HttpStatus.OK);
        }
    }

    public ResponseEntity<String> submitOrder(List<TransProduct> basket) {
        float total = 0;
        List<TransProduct> oprods = new ArrayList<>();
        for(TransProduct req: basket){
            Product prod = pinf.getProductById(req.getProductID()).getBody();
            int inventoryStock = prod.getStock();
            inventoryStock-=req.getQuantity();
            prod.setStock(inventoryStock);
            pinf.putProduct(prod);
            total+= req.getPrice()*req.getQuantity();

            TransProduct t = new TransProduct();
            t.setPrice(req.getPrice());
            t.setQuantity(req.getQuantity());
            t.setProductID(req.getProductID());

            oprods.add(t);
        }
        Orders order = new Orders();
        order.setProducts(oprods);
        order.setTotal(total);

        odao.save(order);

        return new ResponseEntity<>("Order Placed",HttpStatus.OK);
    }
}
