package jwtdemo.jwtTokenDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwtdemo.jwtTokenDemo.models.Role;
import jwtdemo.jwtTokenDemo.services.RoleService;

@RestController
@RequestMapping(path="/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }

    
}
