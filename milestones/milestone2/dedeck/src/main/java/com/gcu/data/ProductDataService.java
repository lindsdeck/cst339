package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {
    
    @Autowired
    private ProductRepository productRepository;
    
    public ProductDataService() {
        
    }
    
    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> products = new ArrayList<>();
        try {
            // Using the custom @Query method from repository
            products = productRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
    @Override
    public ProductEntity findById(long id) {
        try {
            Optional<ProductEntity> product = productRepository.findById(id);
            return product.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean create(ProductEntity product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean update(ProductEntity product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean delete(ProductEntity product) {
        try {
            productRepository.delete(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<ProductEntity> findByCategory(String category) {
        try {
            return productRepository.findByCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public ProductEntity findByProductNumber(String productNumber) {
        try {
            return productRepository.findByProductNumber(productNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean existsByProductNumber(String productNumber) {
        try {
            return productRepository.existsByProductNumber(productNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}