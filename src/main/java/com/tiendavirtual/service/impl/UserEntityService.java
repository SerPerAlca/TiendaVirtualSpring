package com.tiendavirtual.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.tiendavirtual.repository.EmpleadoRepository;
import com.tiendavirtual.repository.entity.EmpleadoEntity;
import com.tiendavirtual.repository.mapper.EmpleadoEntityMapper;
import com.tiendavirtual.repository.mapper.UsuarioEntityMapper;
import com.tiendavirtual.service.IUserService;
import com.tiendavirtual.service.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiendavirtual.repository.UserRepository;
import com.tiendavirtual.repository.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UsuarioEntityMapper mapper;

	@Autowired
	private EmpleadoEntityMapper mapperEmpleado;

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> findAll() {
		List<Empleado> empleados = new ArrayList<>();
		List<UserEntity> userEntity = new ArrayList<>();

		userEntity = userRepository.findAll();
		for (UserEntity user: userEntity){
			Empleado empleadoDomain = mapper.fromEntityToDomain(user);
			empleados.add(empleadoDomain);
		}
		return empleados;
	}

	@Override
	public Optional<Empleado> listarId(int id) {
		return Optional.empty();
	}

	@Override
	public void save(Empleado empleado) {
		try{
			EmpleadoEntity empleadoEntity = mapperEmpleado.fromDomainToEntity(empleado);
			UserEntity userEntity = mapper.fromDomainToEntity(empleado);

			UserEntity userEntityAux = userRepository.save(userEntity);

			int id =userEntityAux.getId();
			empleadoEntity.setId(id);
			empleadoEntity.setUserEntity(userEntity);

			empleadoRepository.save(empleadoEntity);

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al guardar usuario");
		}

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public UserEntity findById(int id) {
		UserEntity userEntity = userRepository.findById(id).get();
		return userEntity;
	}
}
