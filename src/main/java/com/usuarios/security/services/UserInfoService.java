package com.usuarios.security.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usuarios.security.dto.ResponseDto;
import com.usuarios.security.entities.UserCredentials;
import com.usuarios.security.entities.UserInfo;
import com.usuarios.security.exceptions.CustomException;
import com.usuarios.security.repositories.UserCredentialsRepository;
import org.apache.catalina.User;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usuarios.security.repositories.UserInfoRepository;

import java.util.List;

@Service
public class UserInfoService {


    @Autowired
    UserInfoRepository userInfoRepo;
    @Autowired
    UserCredentialsRepository userCredentialsRepo;
    final ObjectMapper mapper = new ObjectMapper();

    public UserInfo createUserInfo(UserInfo userInfo, Long userCredentialsId) throws CustomException {
        try{
            UserCredentials foundUserCredential = userCredentialsRepo.findById(userCredentialsId).orElseThrow(() -> new CustomException("No se pudo crear la informacion de usuario, ya que no existe un usuario con la id: " + userCredentialsId));
            if (userInfoRepo.findByCredentials(foundUserCredential) != null){
                throw new CustomException("Ya existen datos creados para ese usuario");
            }
            userInfo.setCredentials(foundUserCredential);
            return userInfoRepo.save(userInfo);
        }catch(Exception e){
            throw new CustomException(new ResponseDto("400",e.getMessage()));
        }
    }

    public List<UserInfo> getAllUsersInfo(){
        return userInfoRepo.findAll();
    }

    public UserInfo getUserInfoById(Long id) throws CustomException {
        return userInfoRepo.findById(id)
                .orElseThrow(() -> new CustomException(new ResponseDto("404", "No se encontro ninguna informacion de usuario con la id: " + id)));
    }

    public UserInfo updateUserInfo(UserInfo updatedUserInfo, Long id) throws CustomException {
        UserInfo foundUserInfo = userInfoRepo.findById(id)
                .orElseThrow(() -> new CustomException(new ResponseDto("404", "No se encontro ninguna informacion de usuario con la id: " + id)));
        foundUserInfo.setName(updatedUserInfo.getName());
        foundUserInfo.setLastname(updatedUserInfo.getLastname());
        foundUserInfo.setLocation(updatedUserInfo.getLocation());
        foundUserInfo.setAge(updatedUserInfo.getAge());
        return userInfoRepo.save(foundUserInfo);
    }

    public String deleteUserInfo(Long id) throws CustomException {
        UserInfo userInfo = userInfoRepo.findById(id)
                .orElseThrow(() -> new CustomException("No se encontró el usuario con id: " + id));
        userInfoRepo.delete(userInfo);
        return "El usuario con id " + id + " fue borrado correctamente";
    }
}
