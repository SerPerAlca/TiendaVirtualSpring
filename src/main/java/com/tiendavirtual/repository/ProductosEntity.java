package com.tiendavirtual.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class ProductosEntity {
	
	@Id
	@Column(name="id_producto")
	private int id;
	
	@Column(name="nombre_producto")
	private String nombre;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="url_imagen")
	private String urlImagen;
	
	@Column(name="categoria")
	private String categoria;
	
	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public ProductosEntity() {}
	

	public ProductosEntity(String nombre, double precio, String descripcion, String urlImagen, String categoria) {

		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
		this.categoria = categoria;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}


	@Override
	public String toString() {
		return "ProductosEntity [nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", urlImagen=" + urlImagen + ", categoria=" + categoria + "]";
	}


	
	
	
}
