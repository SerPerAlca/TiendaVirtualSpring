package com.tiendavirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiendavirtual.interfaceService.IProductosService;
import com.tiendavirtual.interfaces.IProductos;
import com.tiendavirtual.interfaces.IUser;
import com.tiendavirtual.repository.ProductosEntity;
import com.tiendavirtual.repository.UserEntity;

public class ProductosEntityService implements IProductosService {

	@Autowired
	private IProductos iProductos;
	
	@Override
	public List<ProductosEntity> findAll() {
	
		return (List<ProductosEntity>)iProductos.findAll();
	}

	@Override
	public ProductosEntity findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(ProductosEntity pe) {
	
		return 0;
	}

	@Override
	public void delete(int id) {
		iProductos.deleteById(id);
	}

}
