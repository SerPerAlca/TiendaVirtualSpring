package com.tiendavirtual.repository.mapper;

import com.tiendavirtual.repository.entity.ProductoEntity;
import com.tiendavirtual.service.domain.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoEntityMapper {

    public ProductoEntity fromDomainToEntity(Producto domain) {
        ProductoEntity entity = new ProductoEntity();
        entity.setNombre(domain.getNombre());
        entity.setCategoria(domain.getCategoria());
        entity.setDescripcion(domain.getDescripcion());
        entity.setPrecio(domain.getPrecio());
        entity.setUrlImagen(domain.getUrlImagen());
        return entity;
    }

    public ProductoEntity fromDomainToEntitySinImagen(Producto domain) {
        ProductoEntity entity = new ProductoEntity();
        entity.setNombre(domain.getNombre());
        entity.setCategoria(domain.getCategoria());
        entity.setDescripcion(domain.getDescripcion());
        entity.setPrecio(domain.getPrecio());
        entity.setUrlImagen(domain.getUrlImagen());
        return entity;
    }

    public Producto fromEntitytoDomain(ProductoEntity productoEntity){
        Producto producto = new Producto();
        producto.setNombre(productoEntity.getNombre());
        producto.setDescripcion(productoEntity.getDescripcion());
        producto.setPrecio(productoEntity.getPrecio());
        producto.setCategoria(productoEntity.getCategoria());
        producto.setUrlImagen(productoEntity.getUrlImagen());
        producto.setId(productoEntity.getId());
        return producto;

    }

}