package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.gcu.data.entity.OrderEntity;

@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Long>
{
   
}