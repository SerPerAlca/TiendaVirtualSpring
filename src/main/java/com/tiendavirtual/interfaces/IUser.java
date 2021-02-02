package com.tiendavirtual.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.repository.UserEntity;

@Repository
public interface IUser extends JpaRepository<UserEntity, Integer> {

}
