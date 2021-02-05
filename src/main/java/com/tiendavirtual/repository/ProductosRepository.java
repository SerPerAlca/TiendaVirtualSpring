package com.tiendavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.repository.entity.ProductosEntity;

/** CAPA DE ACCESO A DATOS */
@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity, Integer> {

}
