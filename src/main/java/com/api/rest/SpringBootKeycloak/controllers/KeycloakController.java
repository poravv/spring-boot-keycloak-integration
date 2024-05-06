package com.api.rest.SpringBootKeycloak.controllers;

import com.api.rest.SpringBootKeycloak.controllers.dto.UserDTO;
import com.api.rest.SpringBootKeycloak.service.IKeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/keycloak/user")
@PreAuthorize("hasRole('admin_cli')")
public class KeycloakController {

    @Autowired
    private IKeycloakService keycloakService;


    @GetMapping("/search")
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(keycloakService.findAllUsers());
    }

    @GetMapping("/groups/{userId}")
    public ResponseEntity<?> findAllGroupsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(keycloakService.searchUserByUsernameGroup(userId));
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<?> searchUserByUsername(@PathVariable String username){
         return ResponseEntity.ok(keycloakService.searchUserByUsername(username));
    }

    @PostMapping("/create")
    public HashMap<String, String> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        String response = keycloakService.createUser(userDTO);
        //return ResponseEntity.created(new URI("/keycloak/user/create")).body(response);
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Usuario creado correctamente");
        return map;
    }


    @PutMapping("/update/{userId}")
    public HashMap<String, String> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO){
        keycloakService.updateUser(userId, userDTO);
        //return ResponseEntity.ok("User updated successfully");
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Usuario actualizado correctamente");
        return map;
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        keycloakService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
