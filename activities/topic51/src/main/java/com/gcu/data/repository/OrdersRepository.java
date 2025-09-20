package com.gcu.data.repository;

import org.springframework.stereotype.Repository;
import com.gcu.data.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface OrdersRepository extends MongoRepository<OrderEntity, String>
{
   OrderEntity getOrderById(String id);
}