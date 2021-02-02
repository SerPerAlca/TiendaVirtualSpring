package com.tiendavirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tiendavirtual.interfaceService.IUserService;
import com.tiendavirtual.interfaces.IUser;
import com.tiendavirtual.repository.UserEntity;

public class UserEntityService implements IUserService {
	
	@Autowired
	private IUser iUser;
	
	@Override
	public List<UserEntity> findAll() {
		
		return (List<UserEntity>)iUser.findAll();
	}

	@Override
	public Optional<UserEntity> listarId(int id) {
		// TODO Auto-generated method stub
		return iUser.findById(id);
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
