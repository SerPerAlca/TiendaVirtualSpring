package com.tiendavirtual.repository;

import com.tiendavirtual.repository.entity.EmpleadoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {

}
