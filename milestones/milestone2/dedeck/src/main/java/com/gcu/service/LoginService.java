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
import org.springframework.security.crypto.password.PasswordEncoder;




@Service
public class LoginService 
{

    @Autowired 
    private UserDataService userDataService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(LoginModel loginModel) {
    try {
        System.out.println("******* DEBUG: Starting user registration *******");
        System.out.println("Username: " + loginModel.getUsername());
        System.out.println("Email: " + loginModel.getEmail());
        System.out.println("First Name: " + loginModel.getFirstName());
        
        UserEntity user = new UserEntity();
        user.setUsername(loginModel.getUsername());
        user.setPassword(passwordEncoder.encode(loginModel.getPassword()));
        user.setFirstName(loginModel.getFirstName());
        user.setLastName(loginModel.getLastName());
        user.setEmail(loginModel.getEmail());
        user.setPhone(loginModel.getPhone());
        
        System.out.println("******* DEBUG: User entity created, calling userDataService.create() *******");
        boolean result = userDataService.create(user);
        System.out.println("******* DEBUG: userDataService.create() returned: " + result);
        
        return result;
    } catch (Exception e) {
        System.out.println("******* ERROR in registerUser: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
}