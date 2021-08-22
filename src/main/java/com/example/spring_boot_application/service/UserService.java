package com.example.spring_boot_application.service;


import com.example.spring_boot_application.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public void saveUser(User user);

    public User getUserById(long id);

    public List<User> getAllUsers();

    public void removeUser(long id);

    public void updateUser(User user, long id);

}
