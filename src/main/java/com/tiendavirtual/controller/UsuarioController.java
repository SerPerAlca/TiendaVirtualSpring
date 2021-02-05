package com.tiendavirtual.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tiendavirtual.service.IUserService;
import com.tiendavirtual.repository.entity.UserEntity;

@Controller
public class UsuarioController {

	@Autowired
	private IUserService ius;

	@RequestMapping(value= "/listaruser", method= RequestMethod.GET)
	public String listar(Model model) {
		List<UserEntity> user =ius.findAll();
		model.addAttribute("usuarios", user);
		return "listar-usuarios";
	}

}