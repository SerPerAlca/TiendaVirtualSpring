package com.tiendavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiendavirtual.interfaceService.IProductosService;
import com.tiendavirtual.interfaceService.IUserService;
import com.tiendavirtual.repository.UserEntity;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		/** Aquí inyectamos la lógica que más tarde pasamos a la vista "index" */
		return "index";
	}
	
	
	@Autowired
	private IUserService ius;
	@Autowired private IProductosService ips;

	@RequestMapping(value= "/listaruser", method= RequestMethod.GET)
	public String listar(Model model) {
		List<UserEntity> user =ius.findAll();
		model.addAttribute("usuarios", user);
		return "listar-usuarios";
	}
}
