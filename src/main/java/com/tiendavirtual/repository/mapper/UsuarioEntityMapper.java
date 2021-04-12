package com.tiendavirtual.repository.mapper;

import com.tiendavirtual.repository.entity.UserEntity;
import com.tiendavirtual.service.domain.Cliente;
import com.tiendavirtual.service.domain.Empleado;
import com.tiendavirtual.service.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {


    public Empleado fromEntityToDomain (UserEntity userEntity){
        Empleado empleado = new Empleado();
        empleado.setNombre(userEntity.getNombre());
        empleado.setApellido(userEntity.getApellido());
        empleado.setEmail(userEntity.getEmail());
        empleado.setPassword(userEntity.getPassword());
        empleado.setId(userEntity.getId());
        empleado.setTGSS(userEntity.getEmpleadoEntity().getNumTGSS());
        return empleado;
    }

    public UserEntity fromEmpleadoDomainToEntity(Empleado empleado){
        UserEntity userEntity = new UserEntity();
        userEntity.setNombre(empleado.getNombre());
        userEntity.setApellido(empleado.getApellido());
        userEntity.setEmail(empleado.getEmail());
        userEntity.setPassword(empleado.getPassword());
        userEntity.setId(empleado.getId());
        return userEntity;
    }

    public UserEntity fromClienteDomainToEntity (Cliente cliente){
        UserEntity userEntity = new UserEntity();
        userEntity.setNombre(cliente.getNombre());
        userEntity.setApellido(cliente.getApellido());
        userEntity.setEmail(cliente.getEmail());
        userEntity.setPassword(cliente.getPassword());
        userEntity.setId(cliente.getId());
        return userEntity;
    }

}
