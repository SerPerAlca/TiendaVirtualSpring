package com.tiendavirtual.repository.mapper;

import com.tiendavirtual.repository.entity.ProductosEntity;
import com.tiendavirtual.service.domain.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoEntityMapper {

    public ProductosEntity fromDomainToEntity(Producto domain) {
        ProductosEntity entity = new ProductosEntity();
        entity.setNombre(domain.getNombre());
        entity.setCategoria(domain.getCategoria());
        entity.setDescripcion(domain.getDescripcion());
        entity.setPrecio(domain.getPrecio());
        return entity;
    }


}