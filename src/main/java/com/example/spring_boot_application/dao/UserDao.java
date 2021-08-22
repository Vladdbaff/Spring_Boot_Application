package com.example.spring_boot_application.dao;



import com.example.spring_boot_application.model.User;

import java.util.List;

public interface UserDao {

     void saveUser(User user);

     void updateUser(User user, long id);

     void removeUser(long id);

     User getUserById(long id);

     List<User> getAllUsers();

     User getUserByUsername(String username);

     String getPassword(User user);
}
