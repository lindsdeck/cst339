package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>
{
    @Autowired
    private OrdersRepository ordersRepository;

    public OrdersDataService(OrdersRepository ordersRepository)
    {
        this.ordersRepository = ordersRepository;
    }

    
    @Override
    public OrderEntity findById(long id)
    {
        return null;
    }

    @Override  // Add this annotation
    public List<OrderEntity> findAll()
    {
        List<OrderEntity> orders = new ArrayList<OrderEntity>();
        
        try
        {
            Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
            orders = new ArrayList<OrderEntity>();
            ordersIterable.forEach(orders::add);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orders;
    }

    @Override  // Add this annotation
    public boolean create(OrderEntity order)
    {
        try{
            this.ordersRepository.save(order);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override  // Add this annotation
    public boolean update(OrderEntity order)
    {
        return true;
    }

    @Override  // Add this annotation
    public boolean delete(OrderEntity order)
    {
       return true;
    }
}