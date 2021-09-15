package com.tiendavirtual.controller;


import com.tiendavirtual.controller.dto.ProductoDto;
import com.tiendavirtual.controller.mapper.ProductoDtoMapper;
import com.tiendavirtual.service.IProductosService;
import com.tiendavirtual.service.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrincipalController {

    @Autowired
    private IProductosService productosService;

    @Autowired
    private ProductoDtoMapper mapper;

    @RequestMapping(value="/home/{categoria}", method= RequestMethod.GET)
    public String mostrarTelefonia(@PathVariable String categoria, Model model){
        List<Producto> producto = productosService.findAll();
        List<ProductoDto> productoDto = new ArrayList<>();
        for (Producto product : producto) {
            ProductoDto productDTO = mapper.fromProductoToDto(product);
            if (productDTO.getCategoria().equals(categoria)) {
                productoDto.add(productDTO);
            }
        }
        model.addAttribute("productosCategoria", productoDto);
        return "productosCategoria";
    }

}
