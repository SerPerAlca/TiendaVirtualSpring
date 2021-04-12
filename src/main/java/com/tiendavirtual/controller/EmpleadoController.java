package com.tiendavirtual.controller;

import com.tiendavirtual.controller.dto.EmpleadoDto;
import com.tiendavirtual.controller.mapper.EmpleadoDtoMapper;
import com.tiendavirtual.service.IUserService;
import com.tiendavirtual.service.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

// TODO
@Controller
public class EmpleadoController {

	@Autowired
	private IUserService userService;

	@Autowired
	private EmpleadoDtoMapper mapper;

	@RequestMapping( value="/empleados/list", method = RequestMethod.GET)
	public String listarEmpleados(Model model){
		List<Empleado> listaEmpleados = userService.findAll();
		List<EmpleadoDto> listaEmpleadosDto= new ArrayList<>();
		for ( Empleado empleadoAux : listaEmpleados){
			EmpleadoDto empleadoDto = mapper.fromDomainToDto(empleadoAux);
			listaEmpleadosDto.add(empleadoDto);
		}
		model.addAttribute("empleados", listaEmpleadosDto);
		return "empleados";
	}

	@RequestMapping(value="/empleados/formulario", method= RequestMethod.GET)
	public String formularioEmpleado(Model model){
		model.addAttribute("empleado", new EmpleadoDto());
		return "agregar-empleado";
	}

	@RequestMapping(value="/registro/empleado", method= RequestMethod.POST)
	public String registroEmpleado(@ModelAttribute("worker") EmpleadoDto empleadoDto){

		Empleado empleado = mapper.fromDtoToDomain(empleadoDto);
		userService.saveEmpleado(empleado);
		return "redirect:/empleados/list";
	}

	@RequestMapping(value="/edicionado/empleado/{id}", method= RequestMethod.GET)
	public String editarEmpleado(@PathVariable int id, Model model){
		EmpleadoDto empleadoDto = new EmpleadoDto();
		Empleado empleado = new Empleado();
		empleado = userService.EmpleadofindById(id);
		empleadoDto = mapper.fromDomainToDto(empleado);

		model.addAttribute("worker", empleadoDto);
		return "editar-empleado";
	}

	@RequestMapping(value="/empleadosEdicion", method= RequestMethod.POST)
	public String updateEmpleado(@ModelAttribute("worker") EmpleadoDto empleadoDto){
		Empleado empleado = new Empleado();
		empleado = mapper.fromDtoToDomain(empleadoDto);
		userService.edit(empleado);

		return "redirect:/empleados/list";
	}

	@RequestMapping(value="/eliminado/empleado/{id}", method= RequestMethod.GET)
	public String delete(@PathVariable int id){
		userService.deleteEmpleado(id);
		return "redirect:/empleados/list";

	}
}