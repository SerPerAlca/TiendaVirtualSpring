package com.tiendavirtual.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class ProductosEntity {
	
	@Id
	@Column(name="ID_PRODUCTO")
	private int id;
	
	@Column(name="NOMBRE_PRODUCTO")
	private String nombre;
	
	@Column(name="PRECIO")
	private double precio;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="URL_IMAGEN")
	private String urlImagen;
	
	public ProductosEntity() {}
	
	
	public ProductosEntity(String nombre, double precio, String descripcion, String urlImagen) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
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
				+ ", urlImagen=" + urlImagen + "]";
	}
	
	
}
