package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class OrderEntity 
{
    @Id
    private String id;

    @Indexed(unique = true)
    private String orderNo;

    @Indexed(unique = true)
    private String productName;

    private float price;

    private int quantity;

    // Default constructor (required by MongoDB)
    public OrderEntity() {
    }

    // Constructor with all fields
    public OrderEntity(String id, String orderNo, String productName, float price, int quantity) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}