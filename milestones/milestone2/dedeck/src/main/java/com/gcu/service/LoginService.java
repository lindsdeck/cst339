package com.gcu.service;

import org.springframework.stereotype.Service;
import com.gcu.model.LoginModel;

@Service
public class LoginService 
{
    
    public boolean authenticateUser(LoginModel loginModel) 
    {
        return "admin".equals(loginModel.getUsername()) && 
               "Admin123!".equals(loginModel.getPassword());
    }
    
    public boolean registerUser(LoginModel loginModel) 
    {
        System.out.println("User registered: " + loginModel.getUsername());
        return true;
    }
}