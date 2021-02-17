package com.tiendavirtual.controller.mapper;

import com.tiendavirtual.controller.dto.EmpleadoDto;
import com.tiendavirtual.service.domain.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoDtoMapper {

    public Empleado fromDtoToDomain(EmpleadoDto empleadoDto){
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setApellido(empleadoDto.getApellido());
        empleado.setEmail(empleadoDto.getEmail());
        empleado.setPassword(empleadoDto.getPassword());
        empleado.setTGSS(empleadoDto.getTGSS());
        return empleado;
    }

    public EmpleadoDto fromDomainToDto(Empleado empleado){
         EmpleadoDto empleadoDto = new EmpleadoDto();
         empleadoDto.setNombre(empleado.getNombre());
         empleadoDto.setApellido(empleado.getApellido());
         empleadoDto.setEmail(empleado.getEmail());
         empleadoDto.setPassword(empleado.getPassword());
         empleadoDto.setTGSS(empleado.getTGSS());
         return empleadoDto;
    }

}
