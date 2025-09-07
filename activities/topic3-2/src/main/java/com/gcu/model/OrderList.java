package com.gcu.model;

import java.util.List;  
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
public class OrderList 
{
    private List<OrderModel> orders = new ArrayList<OrderModel>();

    public OrderList()
    {

    }
    public List<OrderModel> getOrders() {
        return orders;
    }   
    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }   
}
