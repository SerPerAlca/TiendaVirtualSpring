package com.tiendavirtual.interfaceService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tiendavirtual.repository.ProductosEntity;



@Service
public interface IProductosService {

	public List<ProductosEntity> findAll();
	public ProductosEntity findByName();
	public void save(ProductosEntity pe);
	public void delete(int id);
	//public void delete(String nombre);
}
