package com.tiendavirtual.controller;

import com.tiendavirtual.controller.dto.ClienteDto;
import com.tiendavirtual.controller.dto.EmpleadoDto;
import com.tiendavirtual.controller.mapper.ClienteDtoMapper;
import com.tiendavirtual.service.IUserService;
import com.tiendavirtual.service.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ClienteDtoMapper mapper;

    @RequestMapping(value="/formulario/cliente", method= RequestMethod.GET)
    public String formularioCliente(Model model){
       model.addAttribute("cliente", new ClienteDto());
        return "agregar-cliente";
    }

    @RequestMapping(value="/registro/cliente", method= RequestMethod.POST)
    public String registroCliente(@ModelAttribute("client") ClienteDto clienteDto){
        Cliente cliente = mapper.fromDtoToDomain(clienteDto);
        userService.saveCliente(cliente);
        return "redirect:/";

    }


}
