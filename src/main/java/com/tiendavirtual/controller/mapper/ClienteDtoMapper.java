package com.tiendavirtual.controller.mapper;

import com.tiendavirtual.controller.dto.ClienteDto;
import com.tiendavirtual.service.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteDtoMapper {

    public Cliente fromDtoToDomain(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setPreferencias(clienteDto.getPreferencias());
        cliente.setUltimaConexion(clienteDto.getUltimaConexion());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setPassword(clienteDto.getPassword());
        cliente.setId(clienteDto.getId());
        return cliente;
    }

    public ClienteDto fromDomainToDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setPreferencias(cliente.getPreferencias());
        clienteDto.setUltimaConexion(cliente.getUltimaConexion());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setPassword(cliente.getPassword());
        clienteDto.setId(cliente.getId());
        return clienteDto;
    }

}
