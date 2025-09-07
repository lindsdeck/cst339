package com.gcu.business;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.gcu.model.OrderModel;  

public class AnotherOrdersBusinessService implements OrdersBusinessInterface
{
    @Override
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        
        List<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel(4L, "0000000005", "Product 5", 5.00f, 5));
        orders.add(new OrderModel(5L, "0000000006", "Product 6", 6.00f, 6));
        orders.add(new OrderModel(6L, "0000000007", "Product 7", 7.00f, 7));
        orders.add(new OrderModel(7L, "0000000008", "Product 8", 8.00f, 8));
        return orders;
    }
}
