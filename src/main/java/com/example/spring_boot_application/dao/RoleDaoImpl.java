package com.example.spring_boot_application.dao;


import com.example.spring_boot_application.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Role getRoleById(long id) {
        return entityManager.find(Role.class, id);
    }
}
