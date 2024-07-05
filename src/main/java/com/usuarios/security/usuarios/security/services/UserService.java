package com.usuarios.security.usuarios.security.services;

import com.usuarios.security.usuarios.security.dto.ResponseDto;
import com.usuarios.security.usuarios.security.entities.User;
import com.usuarios.security.usuarios.security.entities.UserCredentials;
import com.usuarios.security.usuarios.security.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usuarios.security.usuarios.security.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepo;

    public User createUser(User user) throws CustomException {
        try{
            if(user.getCredentials() !=null){
                UserCredentials userCredentials = user.getCredentials();
                userCredentialsService.save(userCredentials);
            }
            return userRepo.save(user);
        }catch(Exception e){
            throw new CustomException(new ResponseDto("400",e.getMessage()));
        }


    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(Long id) throws CustomException {
        return userRepo.findById(id).orElseThrow(() -> new CustomException("No se encontró el usuario con id: " + id));
    }

    public User updateUser(User updatedUser, Long id) throws CustomException {
        User foundUser = userRepo.findById(id).orElseThrow(() -> new CustomException("No se encontró el usuario con id: " + id));
        foundUser.setName(updatedUser.getName());
        foundUser.setLastname(updatedUser.getLastname());
        foundUser.setLocation(updatedUser.getLocation());
        foundUser.setAge(updatedUser.getAge());
        return userRepo.save(foundUser);
    }

    public String deleteUser(Long id) throws CustomException {
        User user = userRepo.findById(id).orElseThrow(() -> new CustomException("No se encontró el usuario con id: " + id));
        userRepo.delete(user);
        return "El usuario con id " + id + " fue borrado correctamente";
    }


}
