package com.tiendavirtual.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.repository.ProductosEntity;


@Repository
public interface IProductos extends JpaRepository<ProductosEntity, Integer> {

}
