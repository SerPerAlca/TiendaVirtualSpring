package com.tiendavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.tiendavirtual.interfaceService.IUserService;
import com.tiendavirtual.interfaces.IUser;
import com.tiendavirtual.service.ServerConf;
import com.tiendavirtual.service.UserEntityService;


@SpringBootApplication
@ComponentScan("com.tiendavirtual")
public class TiendaVirtualSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(TiendaVirtualSpringApplication.class, args);
		 
		  
	}

}
