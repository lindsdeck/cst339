package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>
{
    @Autowired
    private OrdersRepository ordersRepository;
    @SuppressWarnings("unused")
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource)
    {
        this.ordersRepository = ordersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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

    @Override  
    public boolean create(OrderEntity order)
    {
         String sql = "INSERT INTO ORDERS (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
        int rows = 0;

        try 
        {
            rows = jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return rows == 1;
    }

    @Override  
    public boolean update(OrderEntity order)
    {
        return true;
    }

    @Override 
    public boolean delete(OrderEntity order)
    {
       return true;
    }
}