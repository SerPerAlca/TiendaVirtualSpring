package com.tiendavirtual.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.tiendavirtual.repository.ClienteRepository;
import com.tiendavirtual.repository.EmpleadoRepository;
import com.tiendavirtual.repository.entity.ClienteEntity;
import com.tiendavirtual.repository.entity.EmpleadoEntity;
import com.tiendavirtual.repository.mapper.ClienteEntityMapper;
import com.tiendavirtual.repository.mapper.EmpleadoEntityMapper;
import com.tiendavirtual.repository.mapper.UsuarioEntityMapper;
import com.tiendavirtual.service.IUserService;
import com.tiendavirtual.service.domain.Cliente;
import com.tiendavirtual.service.domain.Empleado;
import com.tiendavirtual.service.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiendavirtual.repository.UserRepository;
import com.tiendavirtual.repository.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private UsuarioEntityMapper mapper;

	@Autowired
	private EmpleadoEntityMapper mapperEmpleado;

	@Autowired
	private ClienteEntityMapper mapperCliente;


	@Override
	public List<Cliente> findAllClient() {
		List <Cliente> clientes = new ArrayList<>();
		List <ClienteEntity> clienteEntidad;
		clienteEntidad = clienteRepository.findAll();
		for (ClienteEntity client: clienteEntidad){
			Cliente clienteDomain = mapperCliente.fromEntityToDomain(client);
			clientes.add(clienteDomain);
		}
		return clientes;
	}

	@Override
	public List<Empleado> findAll() {
		List<Empleado> empleados = new ArrayList<>();
		List<EmpleadoEntity> empleadosAux;
		empleadosAux = empleadoRepository.findAll();
		for (EmpleadoEntity user: empleadosAux){
			Empleado empleadoDomain = mapperEmpleado.fromEntityToDomain(user);
			empleados.add(empleadoDomain);
		}
		return empleados;
	}

	//ESTE MÉTODO SEGURAMENTE LO BORRE AL USAR SPRING SECURITY
	@Override
	public Boolean Login(String nombre, String password) {
		List<Cliente> clientes;
		clientes = findAllClient();
		for (Cliente cliente : clientes){
			if(nombre.equals(cliente.getNombre()) && (password.equals(cliente.getPassword()))){
				return true;
			}
		}
		return false;
	}

	@Override
	public Optional<Empleado> listarId(int id) {
		return Optional.empty();
	}

	@Override
	public void saveEmpleado(Empleado empleado) {
		try{
			EmpleadoEntity empleadoEntity = mapperEmpleado.fromDomainToEntity(empleado);
			UserEntity userEntity = mapper.fromEmpleadoDomainToEntity(empleado);

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
	public void saveCliente(Cliente cliente) {

		try{
			ClienteEntity clienteEntity = mapperCliente.fromDomainToEntity(cliente);
			UserEntity userEntity = mapper.fromClienteDomainToEntity(cliente);

			UserEntity userEntityAux = userRepository.save(userEntity);

			int id = userEntityAux.getId();
			clienteEntity.setId(id);
			clienteEntity.setUserEntity(userEntity);
			cliente.setUltimaConexion(LocalDateTime.now());

			clienteRepository.save(clienteEntity);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al salvar cliente");
		}

	}

	@Override
	public void deleteEmpleado(int id) {
		try{
			empleadoRepository.deleteById(id);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar empleado");
		}

		try{
			userRepository.deleteById(id);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar usuario");
		}

	}

	@Override
	public Empleado EmpleadofindById(int id) {
		Empleado empleado = new Empleado();
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();

		empleadoEntity = empleadoRepository.findById(id).get();
		empleado = mapperEmpleado.fromEntityToDomain(empleadoEntity);

		return empleado;

	}

	@Override
	public UserEntity UserfindById(int id) {
		UserEntity userEntity = new UserEntity();
		userEntity = userRepository.findById(id).get();

		return userEntity;
	}

	@Override
	public void edit(Empleado empleado) {
		int id = empleado.getId();
		EmpleadoEntity empleadoOriginal = empleadoRepository.findById(id).get();
		UserEntity usuarioOriginal = userRepository.findById(id).get();
		try{
			empleadoOriginal.setNumTGSS(empleado.getTGSS());
			empleadoRepository.save(empleadoOriginal);

			usuarioOriginal.setId(empleado.getId());
			usuarioOriginal.setNombre(empleado.getNombre());
			usuarioOriginal.setApellido(empleado.getApellido());
			usuarioOriginal.setEmail(empleado.getEmail());
			usuarioOriginal.setPassword(empleado.getPassword());
			userRepository.save(usuarioOriginal);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error al editar registro");
		}
	}


}
