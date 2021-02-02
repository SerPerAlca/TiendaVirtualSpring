package com.tiendavirtual.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.tiendavirtual.interfaceService.IUserService;

@Configuration
@ComponentScan("com.tiendavirtual")
public class ServerConf {
	 	@Bean
	    public InternalResourceViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/jsp/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	 	
	 	@Bean 
	 	public UserEntityService userEntityService() {	
	 		return new UserEntityService();
	 	}
	 	
	 	@Bean
	 	public ProductosEntityService productosEntityService() {
	 		return new ProductosEntityService();
	 	}
	 	
	 	
	 	/**
	 	 * El método addResourceHandler("/static/**") define el patrón de las URL 
	 	 * que se utilizaran para acceder al contenido, el patrón "/static/**" 
	 	 * nos permitirá manejar todo tipo de URL, por otra parte el método 
	 	 * addResourceLocations("/public/") establece la ubicación de los recursos.
	 	 * ej: <img src="static/images/spring-by-pivotal.png" />
	 	 * @param registry
	 	 */
	 	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	         registry.addResourceHandler("/static/**")
	                 .addResourceLocations("/public/");
	     } 
}
