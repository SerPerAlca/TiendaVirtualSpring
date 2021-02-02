package com.tiendavirtual.repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trabajadores")
public class TrabajadorEntity {
	
	@Id
	@Column(name="id_trabajador")
	private int id;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH} )
	@JoinColumn(name="id_usuario")
	private UserEntity userEntity;
	
	public TrabajadorEntity() {}
	
	

	public TrabajadorEntity(UserEntity userEntity) {
		
		this.userEntity = userEntity;
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
		return "TrabajadorEntity [userEntity=" + userEntity + "]";
	}
	
	
	
}
