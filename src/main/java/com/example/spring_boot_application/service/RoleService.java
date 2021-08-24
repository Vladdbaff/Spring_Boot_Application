package com.example.spring_boot_application.service;


import com.example.spring_boot_application.model.Role;

import java.util.Set;

public interface RoleService {

    Role getRoleById(long id);

    Set<Role> getRoleByName(String[] name);




}
