package com.tiendavirtual.repository;

import com.tiendavirtual.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

}