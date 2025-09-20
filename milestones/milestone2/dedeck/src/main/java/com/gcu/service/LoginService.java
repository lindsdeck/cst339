package com.gcu.service;

import java.math.BigDecimal;
import com.gcu.data.ProductDataService;
import com.gcu.data.UserDataService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.LoginModel;
import com.gcu.model.CategoryModel;



@Service
public class LoginService 
{

    @Autowired 
    private UserDataService userDataService;


    public boolean authenticateUser(LoginModel loginModel) 
    {
        return "admin".equals(loginModel.getUsername()) && 
               "Admin123!".equals(loginModel.getPassword());
    }
    
    public boolean registerUser(LoginModel loginModel) 
    {
        try 
        {
            UserEntity user = new UserEntity();
            user.setUsername(loginModel.getUsername());
            user.setPassword(loginModel.getPassword());
            user.setFirstName(loginModel.getFirstName());
            user.setLastName(loginModel.getLastName());
            user.setEmail(loginModel.getEmail());
            user.setPhone(loginModel.getPhone());
            
            return userDataService.create(user);
        } catch (Exception e) 
        {
            e.printStackTrace();
            return false;
        }
    }
}