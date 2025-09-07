package com.gcu.business;

import java.util.List;
import java.util.ArrayList;
import com.gcu.model.OrderModel;    


public class OrdersBusinessService implements OrdersBusinessInterface
{
    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        
        List<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
        orders.add(new OrderModel(1L, "0000000002", "Product 2", 2.00f, 2));
        orders.add(new OrderModel(2L, "0000000003", "Product 3", 3.00f, 3));
        orders.add(new OrderModel(3L, "0000000004", "Product 4", 4.00f, 4));
        return orders;
    }

    @Override
    public void init() {
        System.out.println("********OrdersBusinessService init() method called");
    }   

    @Override 
    public void destroy() {
        System.out.println("*****OrdersBusinessService destroy() method called*****");
        System.out.flush();
    }
}
