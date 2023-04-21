package jwtdemo.jwtTokenDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jwtdemo.jwtTokenDemo.models.JwtRequest;
import jwtdemo.jwtTokenDemo.models.JwtResponse;
import jwtdemo.jwtTokenDemo.services.JwtService;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping(path="/authenticate")
    // public ResponseEntity<String> createJwtToken(@RequestBody JwtRequest request) throws Exception {
    public JwtResponse createJwtToken(@RequestBody JwtRequest request) throws Exception {
        return jwtService.createJwtToken(request);
        // return ResponseEntity.ok(response.toJson().toString());
    }
}
