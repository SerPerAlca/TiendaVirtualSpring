
package com.tiendavirtual.repository.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trabajador")
public class EmpleadoEntity {
	
	@Id
	@Column(name="id_trabajador")
	private int id;

	@Column(name="num_TGSS")
	private int numTGSS;

	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH} )
	@JoinColumn(name="id_usuario")
	private UserEntity userEntity;
	
	public EmpleadoEntity() {}
	
	

	public EmpleadoEntity(UserEntity userEntity) {
		
		this.userEntity = userEntity;
	}

	public EmpleadoEntity(int numTGSS, UserEntity userEntity) {
		this.numTGSS = numTGSS;
		this.userEntity = userEntity;
	}

	public int getNumTGSS() {
		return numTGSS;
	}

	public void setNumTGSS(int numTGSS) {
		this.numTGSS = numTGSS;
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
