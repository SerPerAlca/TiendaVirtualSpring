package com.tiendavirtual.service;

import java.util.List;

import com.tiendavirtual.service.domain.Producto;
import org.springframework.stereotype.Service;


// Capa de servicio
@Service
public interface IProductosService {

	/*
	 * TODO 'public' es redundante, el IDE lo marca en gris. Por defecto en una interfaz, un metodo ya es publico sin necesidad de informarlo
	 */

	List<Producto>  findAll();
	Producto findByName();
	void save(Producto pe);

	void delete(int id);

}
