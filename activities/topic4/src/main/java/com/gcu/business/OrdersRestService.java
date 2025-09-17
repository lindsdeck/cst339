package com.gcu.business;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.business.OrdersBusinessInterface;
import com.gcu.model.OrderModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import java.util.List;
import com.gcu.model.OrderList;


@RestController
@RequestMapping("/service")
public class OrdersRestService 
{
    @Autowired
    private OrdersBusinessInterface service; 

    @GetMapping(path="/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson()
    {
        return service.getOrders();
    }

    @GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
    public OrderList getOrdersAsXml()
    {
        OrderList list = new OrderList();
        list.setOrders(service.getOrders());
        return list;
        
    }
}
