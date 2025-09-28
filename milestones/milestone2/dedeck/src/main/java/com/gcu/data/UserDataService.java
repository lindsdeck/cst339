package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;



@Service
public class UserDataService implements DataAccessInterface<UserEntity>
{

    @Autowired
    private UserRepository userRepository;

    public UserDataService()
    {
        
    }

    @Override
    public List<UserEntity> findAll() 
    {
        List<UserEntity> users = new ArrayList<>();
        try{
            Iterable<UserEntity> userIterable = userRepository.findAll();
            userIterable.forEach(users::add);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return users;
        }

        @Override
        public UserEntity findById(long id) 
        {
            try
            {
                Optional<UserEntity> user = userRepository.findById(id);
                return user.orElse(null);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }            
        }

        @Override
        public boolean create(UserEntity user)
        {
            try 
            {
                userRepository.save(user);
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        public boolean update(UserEntity user)
        {
            try 
            {
                userRepository.save(user);
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
        @Override
        public boolean delete(UserEntity user)
        {
            try 
            {
                userRepository.delete(user);
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }   

        public UserEntity findByUsername(String username)
        {
            try{
                return userRepository.findByUsername(username);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }

        public boolean existsByUsername(String username)
        {
            try{
                return userRepository.existsByUsername(username);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }

        public boolean existsByEmail(String email)
        {
            try{
                return userRepository.existsByEmail(email);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
}
