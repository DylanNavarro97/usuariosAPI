package com.usuarios.security.controllers;

import com.usuarios.security.entities.UserInfo;
import com.usuarios.security.services.UserInfoService;
import com.usuarios.security.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usersinfo")
public class UserInfoController {


    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/{userCredentialsId}")
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userInfo, @PathVariable Long userCredentialsId) throws CustomException {
        return new ResponseEntity<UserInfo>(userInfoService.createUserInfo(userInfo, userCredentialsId), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserInfo> getAllUsers(){
        return userInfoService.getAllUsersInfo();
    }

    @GetMapping("/{id}")
    public UserInfo getUserById(@PathVariable Long id) throws CustomException {
        return userInfoService.getUserInfoById(id);
    }

    @PutMapping("/{id}")
    public UserInfo updateUser(@RequestBody UserInfo userInfo, @PathVariable Long id) throws CustomException {
        return userInfoService.updateUserInfo(userInfo, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) throws CustomException {
        return userInfoService.deleteUserInfo(id);
    }
}
