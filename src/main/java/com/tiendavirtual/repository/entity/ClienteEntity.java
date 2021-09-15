package com.tiendavirtual.repository.entity;

import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;



@Entity
@Table(name = "clientes")
public class ClienteEntity {

	@Id
	@Column(name="id")
	private int id;

	@Column(name="preferencias")
	private String preferencias;

	@Column(name="ultima_conexion")
	private LocalDateTime ultimaConexion;

	@OneToOne(mappedBy = "clienteEntity")
	private UserEntity userEntity;

	public ClienteEntity() {}


	public ClienteEntity(UserEntity userEntity, String preferencias, LocalDateTime ultimaConexion) {
		this.userEntity = userEntity;
		this.preferencias = preferencias;
		this.ultimaConexion = ultimaConexion;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public LocalDateTime getUltimaConexion() {
		return ultimaConexion;
	}

	public void setUltimaConexion(LocalDateTime ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
	}

	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "ClienteEntity [userEntity=" + userEntity + "]";
	}
	
	
}
