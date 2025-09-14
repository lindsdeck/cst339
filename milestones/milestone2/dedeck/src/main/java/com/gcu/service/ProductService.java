package com.gcu.service;

import org.springframework.stereotype.Service;
import com.gcu.model.LoginModel;


@Service
public class ProductService {
    
    public boolean authenticateUser(LoginModel loginModel) {
        // Always return true - no authentication required
        return true;
    }
    
    public boolean registerUser(LoginModel loginModel) {
        // Simulate registration success
        System.out.println("User registered: " + loginModel.getUsername());
        return true;
    }
}
