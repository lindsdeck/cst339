package com.gcu.data;

import com.gcu.model.OrderModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  
import java.util.List;  
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;



@Service
public class OrdersDataService implements DataAccessInterface<OrderModel>
{
    @Autowired
    private DataSource datasource;

    @Autowired 
    private JdbcTemplate jdbcTemplateObject;

    public OrdersDataService(DataSource datasource) 
    {
        this.datasource = datasource;
        this.jdbcTemplateObject = new JdbcTemplate(datasource);

        try {
            int count = jdbcTemplateObject.queryForObject("SELECT COUNT(*) FROM order", Integer.class);
            System.out.println("Database connection successful. Orders count: " + count);
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderModel> findAll() 
    {
        String sql = "SELECT * FROM cst339.orders";
        List<OrderModel> orders = new ArrayList<>();

        try 
        {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) 
            {
                OrderModel order = new OrderModel(
                    srs.getInt("ID"),
                    srs.getString("ORDER_NO"),
                    srs.getString("PRODUCT_NAME"),
                    srs.getFloat("PRICE"),
                    srs.getInt("QUANTITY")
                );
                orders.add(order);
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderModel findById(int id)
    {
        return null;
    }
    @Override
    public boolean create(OrderModel order)
    {
        String sql = "INSERT INTO cst339.orders (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
        int rows = 0;

        try 
        {
            rows = jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
            return rows == 1 ? true : false;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(OrderModel t)
    {
        return true;
    }
    @Override
    public boolean delete(OrderModel t)
    {
        return true;
    }

}
