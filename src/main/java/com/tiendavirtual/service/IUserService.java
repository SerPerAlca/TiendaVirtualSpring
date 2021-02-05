package com.tiendavirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tiendavirtual.repository.entity.UserEntity;

@Service
public interface IUserService {
	
	public List<UserEntity> findAll();
	public Optional<UserEntity> listarId(int id);
	public int save(UserEntity us);
	public void delete(int id);
	
}
