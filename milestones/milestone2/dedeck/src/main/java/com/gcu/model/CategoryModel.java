package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.DecimalMin;


public class CategoryModel 
{
    private Long id;

    @NotNull(message="Category is required")
    private String category;

    @NotNull(message="Name is required")
    private String name;

    @NotNull(message="Description is required")
    private String description;

    @NotNull(message="Price is required")
    @DecimalMin(value="0.0", inclusive=false, message="Price must be greater than zero")
    private Double price;

    @NotNull(message="Quantity is required")
    @Min(value=0, message="Quantity must be zero or greater")
    private Integer quantity;

    @NotNull(message="Product number is required")
    private String productNumber;

    private String useArea;
    private String collection;

    public CategoryModel() {
    }

    public Long getId() {
        return id;
    }   
    public void setId(Long id) {
        this.id = id;
    }   

    public String getCategory() {
        return category;
    }   
    public void setCategory(String category) {
        this.category = category;
    }   
    public String getName() {
        return name;
    }   
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getProductNumber() {
        return productNumber;
    }
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }
    public String getUseArea() {
        return useArea;
    }
    public void setUseArea(String useArea) {
        this.useArea = useArea;
    }
    public String getCollection() {
        return collection;
    }
    public void setCollection(String collection) {
        this.collection = collection;
    }
    

}
