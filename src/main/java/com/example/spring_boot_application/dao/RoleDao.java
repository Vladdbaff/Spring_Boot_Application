package com.example.spring_boot_application.dao;


import com.example.spring_boot_application.model.Role;

import java.util.Set;

public interface RoleDao {

    Role getRoleById(long id);

    Set<Role> getRoleByName(String[] name);



}
