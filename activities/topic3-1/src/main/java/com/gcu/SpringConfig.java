package com.gcu;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.AnotherOrdersBusinessService;

@Configuration
public class SpringConfig 
{

    @Bean(name = "ordersBusinessService")
    public OrdersBusinessInterface getOrdersBusiness()
    {
        return new AnotherOrdersBusinessService();
    }
}
