package com.example.spring_boot_application.service;


import com.example.spring_boot_application.dao.RoleDao;
import com.example.spring_boot_application.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{


    final private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    public Set<Role> getRoleByName(String[] name) {
        return roleDao.getRoleByName(name);
    }
}
