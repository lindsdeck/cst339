package com.gcu.service;

import org.springframework.stereotype.Service;
import com.gcu.model.LoginModel;
import com.gcu.model.CategoryModel;
import com.gcu.data.ProductDataService;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Service
public class ProductService {
    
    @Autowired
    private ProductDataService productDataService;
    
    public boolean addProduct(CategoryModel categoryModel) {
        try {
            System.out.println("=== DEBUG: ProductService.addProduct ===");
            System.out.println("Adding product: " + categoryModel.getName() + ", Category: " + categoryModel.getCategory());
            
            ProductEntity product = new ProductEntity();
            product.setName(categoryModel.getName());
            product.setCategory(categoryModel.getCategory());
            product.setDescription(categoryModel.getDescription());
            product.setPrice(BigDecimal.valueOf(categoryModel.getPrice()));
            product.setQuantity(categoryModel.getQuantity());
            product.setProductNumber(categoryModel.getProductNumber());
            product.setUseArea(categoryModel.getUseArea());
            product.setCollection(categoryModel.getCollection());
            
            boolean result = productDataService.create(product);
            System.out.println("Create result: " + result);
            
            return result;
        } catch (Exception e) {
            System.out.println("ERROR in addProduct: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<CategoryModel> getAllProducts() {
        try {
            System.out.println("=== DEBUG: getAllProducts ===");
            List<ProductEntity> entities = productDataService.findAll();
            System.out.println("Found " + entities.size() + " total products");
            return convertToModelList(entities);
        }
        catch (Exception e) {
            System.out.println("ERROR in getAllProducts: " + e.getMessage());
            e.printStackTrace();    
            return new ArrayList<>();
        }
    }

    public CategoryModel getProductById(long id) {
        try {
            System.out.println("=== DEBUG: getProductById(" + id + ") ===");
            ProductEntity entity = productDataService.findById(id);
            if (entity != null) {
                System.out.println("Found product: " + entity.getName());
                return convertToModel(entity);
            } else {
                System.out.println("No product found with id: " + id);
                return null;
            }
        }
        catch (Exception e) {
            System.out.println("ERROR in getProductById: " + e.getMessage());
            e.printStackTrace();    
            return null;
        }
    }

    public List<CategoryModel> getProductsByCategory(String category) {
        try {
            System.out.println("=== DEBUG: Searching for category: '" + category + "'");
            List<ProductEntity> entities = productDataService.findByCategory(category);
            System.out.println("Found " + entities.size() + " entities");
        
            // Print what we actually found
            for (ProductEntity entity : entities) {
                System.out.println("- Product: " + entity.getName() + ", Category: '" + entity.getCategory() + "'");
            }
        
            return convertToModelList(entities);
        }
        catch (Exception e) {
            System.out.println("ERROR in getProductsByCategory: " + e.getMessage());
            e.printStackTrace();    
            return new ArrayList<>();
        }
    }

    public List<CategoryModel> searchProducts(String query) {
        try {
            List<ProductEntity> allProducts = productDataService.findAll();
            List<ProductEntity> searchResults = new ArrayList<>();

            for (ProductEntity product : allProducts) {
                if (product.getName().toLowerCase().contains(query.toLowerCase()) ||
                    product.getDescription().toLowerCase().contains(query.toLowerCase())) {
                    searchResults.add(product);
                }
            }
            return convertToModelList(searchResults);
        }
        catch (Exception e) {
            e.printStackTrace();    
            return new ArrayList<>();
        }
    }

    public boolean updateProduct(CategoryModel categoryModel) {
        try{
            ProductEntity entity = convertToEntity(categoryModel);
            return productDataService.update(entity);
        }
        catch (Exception e) {
            e.printStackTrace();    
            return false;
        }
    }

    public boolean deleteProduct(Long id) {
        try{
            ProductEntity entity = productDataService.findById(id);
            if (entity != null) {
                return productDataService.delete(entity);
            }
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();    
            return false;
        }
    }

    private List<CategoryModel> convertToModelList(List<ProductEntity> entities) {
        List<CategoryModel> models = new ArrayList<>();
        for (ProductEntity entity : entities) {
            models.add(convertToModel(entity));
        }
        return models;
    }

    private CategoryModel convertToModel(ProductEntity entity) {
        CategoryModel model = new CategoryModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setCategory(entity.getCategory());
        model.setDescription(entity.getDescription());
        model.setPrice(entity.getPrice().doubleValue());
        model.setQuantity(entity.getQuantity());
        model.setProductNumber(entity.getProductNumber());
        model.setUseArea(entity.getUseArea());
        model.setCollection(entity.getCollection());
        return model;
    }

    private ProductEntity convertToEntity(CategoryModel model) {
        ProductEntity entity = new ProductEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setCategory(model.getCategory());
        entity.setDescription(model.getDescription());
        entity.setPrice(BigDecimal.valueOf(model.getPrice()));
        entity.setQuantity(model.getQuantity());
        entity.setProductNumber(model.getProductNumber());
        entity.setUseArea(model.getUseArea());
        entity.setCollection(model.getCollection());
        return entity;
    }
}