package com.tiendavirtual.controller;

import com.tiendavirtual.controller.dto.ProductoDto;
import com.tiendavirtual.controller.mapper.ProductoDtoMapper;
import com.tiendavirtual.service.IProductosService;
import com.tiendavirtual.service.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private IProductosService productosService;

    @Autowired
    private ProductoDtoMapper mapper;

    @RequestMapping(value="/productos", method = RequestMethod.GET)
    public String listarProductos( Model model) {
        List<Producto> productoDomain = productosService.findAll();
        List<ProductoDto> productoDto = new ArrayList<>();
        for (Producto producto : productoDomain){
            ProductoDto productDTO = mapper.fromProductoToDto(producto);
            productoDto.add(productDTO);
        }
        model.addAttribute("productos", productoDto);
        return "productos";
    }

    @GetMapping("/eliminarproducto/{id}")
    public String delete(@PathVariable int id) {
        productosService.delete(id);
        return "redirect:/productos";
    }

    @RequestMapping(value="/agregarproducto", method= RequestMethod.GET)
    public String agregarProducto(Model model) {
        model.addAttribute("producto", new ProductoDto());
        return "agregar-producto";
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String save(@ModelAttribute("producto") ProductoDto productoDto) {

        Producto producto = mapper.fromDtoToDomain(productoDto);

        productosService.save(producto);

        return "redirect:/productos";
    }

}