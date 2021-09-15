package com.tiendavirtual.service;

import java.util.List;

import com.tiendavirtual.service.domain.Producto;
import org.springframework.stereotype.Service;

public interface IProductosService {

	List<Producto>  findAll();

	Producto findByName();

	void save(Producto producto);

	Producto findById(int id);

	void update(Producto producto);

	void delete(int id);

}