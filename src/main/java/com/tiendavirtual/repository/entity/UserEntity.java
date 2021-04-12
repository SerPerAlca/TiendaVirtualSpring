package com.tiendavirtual.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UserEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private int id;

	 @Column(name = "nombre_usuario")
	 private String nombre;

	 @Column(name = "apellido_usuario")
	 private String apellido;
	 
	 @Column(name="email_usuario")
	 private String email;

	 @Column(name="contrasenia")
	 private String password;

	 @OneToOne
	 @JoinColumn(name="id", nullable = true, insertable = false, updatable = false)
	 private EmpleadoEntity empleadoEntity;

	 @OneToOne
	 @JoinColumn(name="id", nullable = true, insertable = false, updatable = false)
	 private ClienteEntity clienteEntity;

	 public UserEntity() {}
	 
	 
	 public UserEntity(String nombre, String apellido, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public void addEmpleado( EmpleadoEntity empleadoEntity){
	 	empleadoEntity.setUserEntity(this);
	 	this.empleadoEntity= empleadoEntity;
	}
	public void removeEmpleado(){
	 	if (empleadoEntity != null){
	 		empleadoEntity.setUserEntity(null);
	 		this.empleadoEntity = null;
		}
	}

	public ClienteEntity getClienteEntity() {
		return clienteEntity;
	}

	public void setClienteEntity(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}

	public EmpleadoEntity getEmpleadoEntity() {
		return empleadoEntity;
	}

	public void setEmpleadoEntity(EmpleadoEntity empleadoEntity) {
		this.empleadoEntity = empleadoEntity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

		@Override
		public String toString() {
			return "UserEntity [nombre=" + nombre + ", apellidos=" + apellido + ", email=" + email + "]";
		}
	    
	    
}
