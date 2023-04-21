package jwtdemo.jwtTokenDemo.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jwtdemo.jwtTokenDemo.dao.RoleDao;
import jwtdemo.jwtTokenDemo.models.Role;
import jwtdemo.jwtTokenDemo.models.User;
import jwtdemo.jwtTokenDemo.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userSvc;

    @Autowired
    private RoleDao roleDao;


    @PostConstruct
    public void initRolesAndUsers() {
        userSvc.initRolesAndUser();
    }
    
    @PostMapping("/registerUser")
    public User registerNewUser(@RequestBody User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userSvc.registerNewUser(user);
    }

    @GetMapping("/forAdmins")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "This URL is only accessible to admin users.";
    }

    @GetMapping("/forUsers") 
    @PreAuthorize("hasRole('User')")
    public String forUsers() {
        return "This URL is accessible to all users.";
    }
}
