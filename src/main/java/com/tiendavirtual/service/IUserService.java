package com.tiendavirtual.service;

import java.util.List;
import java.util.Optional;

import com.tiendavirtual.repository.UserRepository;
import com.tiendavirtual.repository.entity.ClienteEntity;
import com.tiendavirtual.repository.entity.EmpleadoEntity;
import com.tiendavirtual.repository.entity.UserEntity;
import com.tiendavirtual.service.domain.Cliente;
import com.tiendavirtual.service.domain.Empleado;
import com.tiendavirtual.service.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {


	/*---------EMPLEADOS----------*/
	public List<Empleado> findAll();
	public Optional<Empleado> listarId(int id);
	public Empleado EmpleadofindById(int id);
	public void saveEmpleado(Empleado empleado);
	public void edit(Empleado empleado);
	public void deleteEmpleado(int id);


	/*---------CLIENTES---------*/
	public void saveCliente(Cliente cliente);



	/*-------USUARIOS--------*/
	public List<Cliente> findAllClient();
	public UserEntity UserfindById(int id);
	public UserEntity findByNombre(String nombre);



	public Boolean Login(String nombre, String password);







}
