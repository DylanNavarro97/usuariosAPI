package com.usuarios.security.services;

import com.usuarios.security.dto.ResponseDto;
import com.usuarios.security.entities.UserCredentials;
import com.usuarios.security.entities.UserInfo;
import com.usuarios.security.exceptions.CustomException;
import com.usuarios.security.repositories.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usuarios.security.repositories.UserInfoRepository;

import java.util.List;

@Service
public class UserInfoService {


    @Autowired
    UserInfoRepository userRepo;

    public UserInfo createUserInfo(UserInfo userInfo, Long userCredentialsId) throws CustomException {
        try{
            UserCredentials userCredentials = userInfo.getCredentials();
            if (userCredentials != null && userCredentials.getId().equals(userCredentialsId)){
                return userRepo.save(userInfo);
            } else {
                throw new CustomException("La id ingresada no coincide con ningun usuario.");
            }
        }catch(Exception e){
            throw new CustomException(new ResponseDto("400",e.getMessage()));
        }
    }

    public List<UserInfo> getAllUsersInfo(){
        return userRepo.findAll();
    }

    public UserInfo getUserInfoById(Long id) throws CustomException {
        return userRepo.findById(id).orElseThrow(() -> new CustomException("No se encontró el usuario con id: " + id));
    }

    public UserInfo updateUserInfo(UserInfo updatedUserInfo, Long id) throws CustomException {
        UserInfo foundUserInfo = userRepo.findById(id).orElseThrow(() -> new CustomException("No se encontró el usuario con id: " + id));
        foundUserInfo.setName(updatedUserInfo.getName());
        foundUserInfo.setLastname(updatedUserInfo.getLastname());
        foundUserInfo.setLocation(updatedUserInfo.getLocation());
        foundUserInfo.setAge(updatedUserInfo.getAge());
        return userRepo.save(foundUserInfo);
    }

    public String deleteUserInfo(Long id) throws CustomException {
        UserInfo userInfo = userRepo.findById(id).orElseThrow(() -> new CustomException("No se encontró el usuario con id: " + id));
        userRepo.delete(userInfo);
        return "El usuario con id " + id + " fue borrado correctamente";
    }


}
