package com.tiendavirtual.repository.entity;

import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteEntity {

	@Id
	@Column(name="id_cliente")
	private int id;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH} )
	@JoinColumn(name="id_usuario")
	private UserEntity userEntity;

	@Column(name="preferencias")
	private String preferencias;

	@Column(name="ultima_conexion")
	private LocalGregorianCalendar.Date ultimaConexion;
	
	public ClienteEntity() {}


	public ClienteEntity(UserEntity userEntity, String preferencias, LocalGregorianCalendar.Date ultimaConexion) {
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

	public LocalGregorianCalendar.Date getUltimaConexion() {
		return ultimaConexion;
	}

	public void setUltimaConexion(LocalGregorianCalendar.Date ultimaConexion) {
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
