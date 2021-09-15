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

        if (dto.getImagen() != null) {
            producto.setUrlImagen(dto.getImagen().getOriginalFilename());
        }

        producto.setId(dto.getId());

        try {
            producto.setImagen(dto.getImagen().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return producto;
    }
    public Producto fromDtoToDomainWhitoutImage(ProductoDto dto){
        Producto producto = new Producto();
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        return producto;
    }
    public ProductoDto fromProductoToDto(Producto productoDomain){
        ProductoDto productoDto = new ProductoDto();
        productoDto.setNombre(productoDomain.getNombre());
        productoDto.setPrecio(productoDomain.getPrecio());
        productoDto.setDescripcion(productoDomain.getDescripcion());
        productoDto.setCategoria(productoDomain.getCategoria());
        productoDto.setUrlImagen(productoDomain.getUrlImagen());
        productoDto.setId(productoDomain.getId());
        return productoDto;
    }

}