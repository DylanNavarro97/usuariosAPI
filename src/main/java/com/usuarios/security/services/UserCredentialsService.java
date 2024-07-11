package com.usuarios.security.services;

import com.usuarios.security.dto.ResponseDto;
import com.usuarios.security.entities.UserCredentials;
import com.usuarios.security.exceptions.CustomException;
import com.usuarios.security.repositories.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    UserCredentialsRepository userRepo;

    public String createUserCredentials(UserCredentials userCredentials) throws CustomException {
        try{
            userRepo.save(userCredentials);
            return "El usuario fue creado exitosamente.";
        } catch (Exception e){
            throw new CustomException(new ResponseDto("400", e.getMessage()));
        }
    }


}
