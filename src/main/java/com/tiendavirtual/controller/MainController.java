package com.tiendavirtual.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import ch.qos.logback.core.CoreConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tiendavirtual.interfaceService.IProductosService;
import com.tiendavirtual.interfaceService.IUserService;
import com.tiendavirtual.repository.ProductosEntity;
import com.tiendavirtual.repository.UserEntity;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		/** Aquí inyectamos la lógica que más tarde pasamos a la vista "index" */
		return "index";
	}
	
	/*
	 * *********************** MÉTODOS USUARIOS ***********************************************
	 */
	@Autowired
	private IUserService ius;
	@Autowired private IProductosService ips;

	@RequestMapping(value= "/listaruser", method= RequestMethod.GET)
	public String listar(Model model) {
		List<UserEntity> user =ius.findAll();
		model.addAttribute("usuarios", user);
		return "listar-usuarios";
	}
	
	/*
	 * ********************* MÉTODOS PRODUCTOS ***********************************************
	 */
	@RequestMapping(value="/productos", method = RequestMethod.GET)
	public String listarProductos( Model model) {
		List<ProductosEntity> prod = ips.findAll();
		model.addAttribute("productos", prod);
		return "productos";
	}
	
	@GetMapping("/eliminarproducto/{id}")
	public String delete(@PathVariable int id) {	
		ips.delete(id);
		return "redirect:/productos";
	}
	
	@RequestMapping(value="/agregarproducto", method= RequestMethod.GET)
	public String agregarProducto(Model model) {
		model.addAttribute("producto", new ProductosEntity());
		return "agregar-producto";
	}
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String save(
			@RequestParam("precio") double precio,
			@RequestParam("nombre") String nombre,
			@RequestParam("categoria") String categoria,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("urlImagen") MultipartFile imagen,
			@ModelAttribute("producto") ProductosEntity producto) {
			String url = null;

		if (!imagen.isEmpty()) {
			Path directorioImagen = Paths.get("src//main//webapp//public/images");
			String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
				Files.write(rutaCompleta,  bytesImg);
				url = "/public/images/"+imagen.getOriginalFilename();
				producto.setUrlImagen(url);
				producto.setNombre(nombre);
				producto.setCategoria(categoria);
				producto.setDescripcion(descripcion);
				producto.setPrecio(precio);
				ips.save(producto);
				System.out.println("Registro guardado correctamente");

			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("No se ha podido almacenar archivo");
			}
		}
			return "redirect:/productos";
	}

	/*
	************** prueba subida de archivooo **********************************
	 */
	@RequestMapping(value="/subirimagen", method= RequestMethod.GET)
	public String pruebasubir() {

		return "pruebaSubida";
	}
	@RequestMapping(value="/saveprueba", method= RequestMethod.POST)
	public String metodoPrueba(@RequestParam("urlImagen") MultipartFile imagen) {
		String ulrImagen = null;
		if (!imagen.isEmpty()) {
			Path directorioImagen = Paths.get("src//main//webapp//public/images");
			String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				ulrImagen = "/public/images/" + imagen.getOriginalFilename();
				System.out.println("archivo subido");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "index";
	}
}
