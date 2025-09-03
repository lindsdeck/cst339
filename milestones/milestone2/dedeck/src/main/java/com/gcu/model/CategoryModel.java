package com.gcu.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class CategoryModel 
{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private String categoryName;
}
