package com.api.rest.SpringBootKeycloak.service;

import com.api.rest.SpringBootKeycloak.controllers.dto.UserDTO;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IKeycloakService {

    List<UserRepresentation> findAllUsers();
    List<UserRepresentation> searchUserByUsername(String username);
    List<GroupRepresentation> searchUserByUsernameGroup(String id);
    String createUser(UserDTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);
}
