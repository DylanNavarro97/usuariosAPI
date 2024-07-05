package com.usuarios.security.usuarios.security.services;

import com.usuarios.security.usuarios.security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usuarios.security.usuarios.security.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public User createUser(User user){
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el usuario con id: " + id));
    }

    public User updateUser(User updatedUser, Long id){
        User foundUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el usuario con id: " + id));
        foundUser.setName(updatedUser.getName());
        foundUser.setLastname(updatedUser.getLastname());
        foundUser.setLocation(updatedUser.getLocation());
        foundUser.setAge(updatedUser.getAge());
        return userRepo.save(foundUser);
    }

    public String deleteUser(Long id){
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el usuario con id: " + id));
        userRepo.delete(user);
        return "El usuario con id " + id + " fue borrado correctamente";
    }


}
