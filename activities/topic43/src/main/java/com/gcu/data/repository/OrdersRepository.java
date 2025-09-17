package com.gcu.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.gcu.data.entity.OrderEntity;
import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Long>
{
    @Query(value = "SELECT * FROM ORDERS", nativeQuery = true)
    public List<OrderEntity> findAll();
}