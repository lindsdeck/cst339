package com.gcu.service;

import org.springframework.stereotype.Service;
import com.gcu.model.LoginModel;
import com.gcu.model.CategoryModel;
import com.gcu.data.ProductDataService;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;



@Service
public class ProductService {
    
    @Autowired
    private ProductDataService productDataService;
    
    public boolean addProduct(CategoryModel categoryModel) {
        try {
            ProductEntity product = new ProductEntity();
            product.setName(categoryModel.getName());
            product.setCategory(categoryModel.getCategory());
            product.setDescription(categoryModel.getDescription());
            product.setPrice(BigDecimal.valueOf(categoryModel.getPrice()));
            product.setQuantity(categoryModel.getQuantity());
            product.setProductNumber(categoryModel.getProductNumber());
            product.setUseArea(categoryModel.getUseArea());
            product.setCollection(categoryModel.getCollection());
            
            return productDataService.create(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
