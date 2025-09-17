package com.gcu;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrdersBusinessService;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SpringConfig 
{

    @Bean(name = "ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
    public OrdersBusinessInterface getOrdersBusiness()
    {
        return new OrdersBusinessService();
    }
}
