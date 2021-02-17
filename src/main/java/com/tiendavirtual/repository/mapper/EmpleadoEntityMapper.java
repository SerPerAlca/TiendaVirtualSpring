package com.tiendavirtual.repository.mapper;

import com.tiendavirtual.repository.entity.EmpleadoEntity;
import com.tiendavirtual.service.domain.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoEntityMapper {

    public Empleado fromEntityToDomain(EmpleadoEntity empleadoEntity){
        Empleado empleado = new Empleado();
        empleado.setTGSS(empleadoEntity.getNumTGSS());
        return empleado;
    }

    public EmpleadoEntity fromDomainToEntity(Empleado empleado){
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setNumTGSS(empleado.getTGSS());
        return empleadoEntity;
    }
}
