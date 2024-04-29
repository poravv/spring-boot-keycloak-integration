package com.api.rest.SpringBootKeycloak.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class TestController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('admin_cli')")
    public boolean helloAdmin(){
        return true;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('user_cli') or hasRole('client_admin')")
    public boolean helloUser(){
        return true;
    }
}
