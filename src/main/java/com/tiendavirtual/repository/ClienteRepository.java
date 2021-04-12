package com.tiendavirtual.repository;

import com.tiendavirtual.repository.entity.ClienteEntity;
import com.tiendavirtual.repository.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

}
