package com.tiendavirtual.controller.mapper;

import com.tiendavirtual.controller.dto.ProductoDto;
import com.tiendavirtual.service.domain.Producto;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProductoDtoMapper {

    public Producto fromDtoToDomain(ProductoDto dto) {
        Producto producto = new Producto();
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setNombreImagen(dto.getImagen().getOriginalFilename());

        try {
            producto.setImagen(dto.getImagen().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return producto;
    }

}