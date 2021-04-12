package com.tiendavirtual.service;

import java.util.List;
import java.util.Optional;

import com.tiendavirtual.repository.entity.UserEntity;
import com.tiendavirtual.service.domain.Cliente;
import com.tiendavirtual.service.domain.Empleado;
import com.tiendavirtual.service.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

	public List<Cliente> findAllClient();
	public List<Empleado> findAll();
	public Boolean Login(String nombre, String password);
	public Optional<Empleado> listarId(int id);
	public void saveEmpleado(Empleado empleado);
	public void saveCliente(Cliente cliente);
	public Empleado EmpleadofindById(int id);
	public UserEntity UserfindById(int id);
	public void edit(Empleado empleado);
	public void deleteEmpleado(int id);
}
