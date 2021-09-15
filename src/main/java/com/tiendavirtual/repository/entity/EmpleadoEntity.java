
package com.tiendavirtual.repository.entity;

import javax.persistence.*;


@Entity
@Table(name = "empleados")
public class EmpleadoEntity {
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="num_TGSS")
	private String numTGSS;

	@OneToOne(mappedBy = "empleadoEntity")
	private UserEntity userEntity;

	public EmpleadoEntity() {}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getNumTGSS() {
		return numTGSS;
	}

	public void setNumTGSS(String numTGSS) {
		this.numTGSS = numTGSS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "EmpleadoEntity{" +
				"id=" + id +
				", numTGSS='" + numTGSS + '\'' +
				'}';
	}
}
