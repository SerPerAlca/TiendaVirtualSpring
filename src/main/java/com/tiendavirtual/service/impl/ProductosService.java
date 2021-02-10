package com.tiendavirtual.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.tiendavirtual.repository.mapper.ProductoEntityMapper;
import com.tiendavirtual.service.IProductosService;
import com.tiendavirtual.service.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendavirtual.repository.ProductosRepository;
import com.tiendavirtual.repository.entity.ProductoEntity;

// capa de servicio

/**
 * TODO renombrar a ProductosService, 'entity' ahi no aporta informacion relevante, ademas, entity es informacion de la capa de persistencia
 */
@Service
public class ProductosService implements IProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ProductoEntityMapper mapper;

    @Override
    public List<Producto> findAll() {
        List<Producto> productoDomain = new ArrayList<>();
        List<ProductoEntity> productoEntity = new ArrayList<>();

        productoEntity = productosRepository.findAll();
        for (ProductoEntity entidad : productoEntity) {
            Producto producto = mapper.fromEntitytoDomain(entidad);
            productoDomain.add(producto);
        }
        return productoDomain;
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
            Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + producto.getUrlImagen());
            Files.write(rutaCompleta, imagen);
            String url = "/public/images/" + producto.getUrlImagen();

            ProductoEntity productoEntity = mapper.fromDomainToEntity(producto);
            productoEntity.setUrlImagen(url);

            productosRepository.save(productoEntity);
            System.out.println("Registro guardado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se ha podido almacenar archivo");
        }
    }
    @Override
    public void saveSinImagen(Producto producto) {
        ProductoEntity productoEntity = mapper.fromDomainToEntity(producto);
        try {
            productosRepository.save(productoEntity);
            System.out.println("Salvado sin imagen");
        }catch (Exception e){
            System.out.println("Error al intentar salvar sin imagen");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        productosRepository.deleteById(id);
    }


    public Producto findById(int id) {
        Producto producto = new Producto();
        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity = productosRepository.findById(id).get();
        producto = mapper.fromEntitytoDomain(productoEntity);

        return producto;

    }

    @Override
    public void edit(Producto producto) {
       int id = producto.getId();
       Producto product = findById(id);
       product.setNombre(producto.getNombre());
       product.setPrecio(producto.getPrecio());
       product.setDescripcion(producto.getDescripcion());
       product.setCategoria(producto.getCategoria());
       product.setUrlImagen(producto.getUrlImagen());
       if (producto.getImagen() == null){
           saveSinImagen(product);
       }else
       save(product);
       }




}
