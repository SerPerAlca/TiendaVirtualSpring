package com.tiendavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendavirtual.repository.entity.ProductoEntity;

public interface ProductosRepository extends JpaRepository<ProductoEntity, Integer> {

    ProductoEntity findByCategoria(String categoria);

}