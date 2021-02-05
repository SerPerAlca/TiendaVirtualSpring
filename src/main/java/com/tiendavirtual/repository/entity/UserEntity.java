package com.tiendavirtual.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UserEntity {

	 @Id
	 @Column(name = "id_usuario")
	 private int id;

	 @Column(name = "nombre_usuario")
	 private String nombre;

	 @Column(name = "apellido_usuario")
	 private String apellidos;
	 
	 @Column(name="email_usuario")
	 private String email;
	 
	 
	 public UserEntity() {}
	 
	 
	 public UserEntity(String nombre, String apellidos, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}


	public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellidos() {
	        return apellidos;
	    }

	    public void setApellidos(String apellidos) {
	        this.apellidos = apellidos;
	    }

		@Override
		public String toString() {
			return "UserEntity [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + "]";
		}
	    
	    
}
