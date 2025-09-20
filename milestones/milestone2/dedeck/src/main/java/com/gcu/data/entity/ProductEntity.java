package com.gcu.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.math.BigDecimal;

@Entity
@Table(name = "products")   
public class ProductEntity 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name", nullable = false, length = 255)
    private String name;

    @Column(name= "description", columnDefinition = "TEXT")
    private String description;

    @Column(name= "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name= "quantity")
    private Integer quantity;

    @Column(name = "category", length = 50)
    private String category;

    @Column(name = "product_number", length = 50, unique = true)
    private String productNumber;

    @Column(name = "use_area", length = 255)
    private String useArea;

    @Column(name = "collection", length = 255)
    private String collection;

    public ProductEntity()
    {

    }

    public ProductEntity(String name, String description, BigDecimal price, Integer quantity, String productNumber, String category) 
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.productNumber = productNumber;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
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
