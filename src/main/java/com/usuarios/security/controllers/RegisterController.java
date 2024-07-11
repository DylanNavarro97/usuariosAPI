package com.usuarios.security.controllers;

import com.usuarios.security.entities.UserCredentials;
import com.usuarios.security.exceptions.CustomException;
import com.usuarios.security.services.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserCredentialsService userCredentialsService;

    @PostMapping
    public ResponseEntity<String> userRegister(@RequestBody UserCredentials userCredentials) throws CustomException {
        return new ResponseEntity<String>(userCredentialsService.createUserCredentials(userCredentials) , HttpStatus.CREATED);
    }
}
