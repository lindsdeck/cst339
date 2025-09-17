package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import com.gcu.model.OrderModel;  
import com.gcu.data.DataAccessInterface;
import org.springframework.stereotype.Service;  



public class OrdersBusinessService implements OrdersBusinessInterface
{
    @Autowired
    private DataAccessInterface<OrderModel> service;

    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        
        return service.findAll();
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
