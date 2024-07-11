package com.usuarios.security.repositories;

import com.usuarios.security.entities.UserCredentials;
import com.usuarios.security.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

    public UserInfo findByCredentials(UserCredentials credentials);
}
