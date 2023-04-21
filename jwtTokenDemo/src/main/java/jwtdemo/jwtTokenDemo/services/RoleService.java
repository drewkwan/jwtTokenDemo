package jwtdemo.jwtTokenDemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwtdemo.jwtTokenDemo.dao.RoleDao;
import jwtdemo.jwtTokenDemo.models.Role;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    
    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }

}
