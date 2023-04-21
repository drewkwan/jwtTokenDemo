package jwtdemo.jwtTokenDemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jwtdemo.jwtTokenDemo.models.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
    
}
