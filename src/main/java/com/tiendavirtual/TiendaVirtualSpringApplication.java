package com.tiendavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Por defecto el componentScan se posiiciona en el paquete de la clase anotada
con @SpringBootApplication
 */
@SpringBootApplication
public class TiendaVirtualSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaVirtualSpringApplication.class, args);
	}

}