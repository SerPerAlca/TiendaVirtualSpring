package com.tiendavirtual.service.impl;

import java.util.List;
import java.util.Optional;

import com.tiendavirtual.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiendavirtual.repository.UserRepository;
import com.tiendavirtual.repository.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserEntity> findAll() {
		
		return (List<UserEntity>) userRepository.findAll();
	}

	@Override
	public Optional<UserEntity> listarId(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public int save(UserEntity us) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	


}
