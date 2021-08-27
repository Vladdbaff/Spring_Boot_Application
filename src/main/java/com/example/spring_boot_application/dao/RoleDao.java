package com.example.spring_boot_application.dao;


import com.example.spring_boot_application.model.Role;

import java.util.Set;

public interface RoleDao {

    Set<Role> getRoleByName(String[] name);



}
