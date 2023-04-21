package jwtdemo.jwtTokenDemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jwtdemo.jwtTokenDemo.models.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {
    
}
