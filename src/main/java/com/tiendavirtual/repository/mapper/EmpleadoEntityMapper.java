package com.tiendavirtual.repository.mapper;

import com.tiendavirtual.repository.entity.EmpleadoEntity;
import com.tiendavirtual.service.domain.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoEntityMapper {

    public Empleado fromEntityToDomain(EmpleadoEntity empleadoEntity){
        Empleado empleado = new Empleado();
        empleado.setTGSS(empleadoEntity.getNumTGSS());
        empleado.setId(empleadoEntity.getId());
        empleado.setNombre(empleadoEntity.getUserEntity().getNombre());
        empleado.setApellido(empleadoEntity.getUserEntity().getApellido());
        empleado.setEmail(empleadoEntity.getUserEntity().getEmail());
        empleado.setPassword(empleadoEntity.getUserEntity().getPassword());
        return empleado;
    }

    public EmpleadoEntity fromDomainToEntity(Empleado empleado){
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setNumTGSS(empleado.getTGSS());
        empleadoEntity.setId(empleado.getId());
        return empleadoEntity;
    }


}
