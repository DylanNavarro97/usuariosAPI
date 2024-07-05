package com.usuarios.security.usuarios.security.repositories;

import com.usuarios.security.usuarios.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
