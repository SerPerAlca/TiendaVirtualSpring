package com.tiendavirtual.repository.mapper;

import com.tiendavirtual.repository.entity.UserEntity;
import com.tiendavirtual.service.domain.Empleado;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {


    public Empleado fromEntityToDomain (UserEntity userEntity){
        Empleado empleado = new Empleado();
        empleado.setNombre(userEntity.getNombre());
        empleado.setApellido(userEntity.getApellido());
        empleado.setEmail(userEntity.getEmail());
        empleado.setPassword(userEntity.getPassword());
        empleado.setTGSS(userEntity.getEmpleadoEntity().getNumTGSS());
        return empleado;
    }

    public UserEntity fromDomainToEntity ( Empleado empleado){
        UserEntity userEntity = new UserEntity();
        userEntity.setNombre(empleado.getNombre());
        userEntity.setApellido(empleado.getApellido());
        userEntity.setEmail(empleado.getEmail());
        userEntity.setPassword(empleado.getPassword());
        return userEntity;
    }
}
