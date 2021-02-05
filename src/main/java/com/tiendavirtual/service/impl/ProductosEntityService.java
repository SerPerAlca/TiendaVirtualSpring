package com.tiendavirtual.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.tiendavirtual.repository.mapper.ProductoEntityMapper;
import com.tiendavirtual.service.IProductosService;
import com.tiendavirtual.service.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendavirtual.repository.ProductosRepository;
import com.tiendavirtual.repository.entity.ProductosEntity;

// capa de servicio
/**
 * TODO renombrar a ProductosService, 'entity' ahi no aporta informacion relevante, ademas, entity es informacion de la capa de persistencia
 */
@Service
public class ProductosEntityService implements IProductosService {

	@Autowired
	private ProductosRepository productosRepository;

	@Autowired
	private ProductoEntityMapper mapper;
	
	@Override
	public List<Producto> findAll() {

		return null;
//		return (List<ProductosEntity>) productosRepository.findAll();
	}

	@Override
	public Producto findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(Producto producto) {

		Path directorioImagen = Paths.get("src//main//webapp//public/images");
		String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();

		try {
			byte[] imagen = producto.getImagen();
			Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ producto.getNombreImagen());
			Files.write(rutaCompleta,  imagen);
			String url = "/public/images/" + producto.getNombreImagen();

			ProductosEntity productoEntity = mapper.fromDomainToEntity(producto);
			productoEntity.setUrlImagen(url);

			productosRepository.save(productoEntity);
			System.out.println("Registro guardado correctamente");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("No se ha podido almacenar archivo");
		}
	}

	@Override
	public void delete(int id) {
		productosRepository.deleteById(id);
	}

}