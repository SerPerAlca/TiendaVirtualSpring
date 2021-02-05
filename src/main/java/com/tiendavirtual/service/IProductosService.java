package com.tiendavirtual.service;

import java.util.List;

import com.tiendavirtual.service.domain.Producto;
import org.springframework.stereotype.Service;

import com.tiendavirtual.repository.entity.ProductosEntity;


// Capa de servicio
@Service
public interface IProductosService {

	/*
	 * TODO 'public' es redundante, el IDE lo marca en gris. Por defecto en una interfaz, un metodo ya es publico sin necesidad de informarlo
	 */

	public List<Producto>  findAll();
	public Producto findByName();
	public void save(Producto pe);

	public void delete(int id);

}
