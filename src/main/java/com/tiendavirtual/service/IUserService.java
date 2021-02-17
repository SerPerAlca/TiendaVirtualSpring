package com.tiendavirtual.service;

import java.util.List;
import java.util.Optional;

import com.tiendavirtual.repository.entity.UserEntity;
import com.tiendavirtual.service.domain.Empleado;
import com.tiendavirtual.service.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
	
	public List<Empleado> findAll();
	public Optional<Empleado> listarId(int id);
	public void save(Empleado empleado);
	public void delete(int id);
	public UserEntity findById(int id);
}
