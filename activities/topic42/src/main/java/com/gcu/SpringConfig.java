package com.gcu;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrdersBusinessService;
import com.gcu.data.OrdersDataService;

@Configuration
public class SpringConfig 
{
    @Bean(name = "ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
    public OrdersBusinessInterface getOrdersBusiness(OrdersDataService ordersDataService)
    {
        return new OrdersBusinessService(ordersDataService);
    }
}
