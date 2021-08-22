package com.example.spring_boot_application.service;


import com.example.spring_boot_application.dao.RoleDao;
import com.example.spring_boot_application.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleById(long id) {
        return roleDao.getRoleById(id);
    }
}
