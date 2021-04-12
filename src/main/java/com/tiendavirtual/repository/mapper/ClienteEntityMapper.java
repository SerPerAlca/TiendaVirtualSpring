package com.tiendavirtual.repository.mapper;

import com.tiendavirtual.repository.entity.ClienteEntity;
import com.tiendavirtual.service.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityMapper {

    public Cliente fromEntityToDomain(ClienteEntity clienteEntity){
        Cliente cliente = new Cliente();
        cliente.setPreferencias(clienteEntity.getPreferencias());
        cliente.setUltimaConexion(clienteEntity.getUltimaConexion());
        cliente.setNombre(clienteEntity.getUserEntity().getNombre());
        cliente.setApellido(clienteEntity.getUserEntity().getApellido());
        cliente.setEmail(clienteEntity.getUserEntity().getEmail());
        cliente.setPassword(clienteEntity.getUserEntity().getPassword());
        cliente.setId(clienteEntity.getId());
        return cliente;
    }
    public ClienteEntity fromDomainToEntity (Cliente cliente){
        ClienteEntity clienteEntity= new ClienteEntity();
        clienteEntity.setId(cliente.getId());
        clienteEntity.setPreferencias(cliente.getPreferencias());
        clienteEntity.setUltimaConexion(cliente.getUltimaConexion());
        return clienteEntity;
    }
}
