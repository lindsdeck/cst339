package com.gcu.business;

import java.util.List;
import java.util.ArrayList;
import com.gcu.model.OrderModel;    
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.OrdersDataService;

public class OrdersBusinessService implements OrdersBusinessInterface
{
    private OrdersDataService service;

    public OrdersBusinessService(OrdersDataService service) {
        this.service = service;
    }

    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        
        List<OrderEntity> ordersEntity = service.findAll();

        List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
        for(OrderEntity entity : ordersEntity)
        {
            // Fixed: entity.GetPrice() should be entity.getPrice()
            ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
        }
        return ordersDomain;
    }

    @Override
    public void init() {
        System.out.println("********OrdersBusinessService init() method called");
    }   

    @Override 
    public void destroy() {
        System.out.println("*****OrdersBusinessService destroy() method called*****");
        
    }

    @Override
    public OrderModel getOrderById(String id)
    {
        OrderEntity orderEntity = service.findById(id);

        return new OrderModel(orderEntity.getId(), orderEntity.getOrderNo(), orderEntity.getProductName(), orderEntity.getPrice(), orderEntity.getQuantity());
    }
}