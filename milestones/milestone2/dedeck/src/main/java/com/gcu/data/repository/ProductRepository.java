package com.gcu.data.repository;

import com.gcu.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;   
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>
{

    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<ProductEntity> findAll();

    List<ProductEntity> findByCategory(String category);

    ProductEntity findByProductNumber(String productNumber);

    boolean existsByProductNumber(String productNumber);
}
