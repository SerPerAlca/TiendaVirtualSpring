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
/*
   TODO Intentar mandar la solicitud de edición de productos con método PUT url /productos.
   de momento me la envía como POST aunque indique PUT en el method del form.
 */
@Controller
public class ProductoController {

    @Autowired
    private IProductosService productosService;

    @Autowired
    private ProductoDtoMapper mapper;


    @RequestMapping(value="/productos/list", method = RequestMethod.GET)
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

    @RequestMapping(value="/eliminado/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable int id) {
        productosService.delete(id);
        return "redirect:/productos/list";
    }

    @RequestMapping(value="/productos/formulario", method= RequestMethod.GET)
    public String agregarProducto(Model model) {
        model.addAttribute("producto", new ProductoDto());
        return "agregar-producto";
    }

    @RequestMapping(value="/productos", method= RequestMethod.POST)
    public String save(@ModelAttribute("product") ProductoDto productoDto) {

        Producto producto = mapper.fromDtoToDomain(productoDto);

        productosService.save(producto);

        return "redirect:/productos/list";
    }

    @RequestMapping(value="/edicionado/{id}", method= RequestMethod.GET)
    public String editarProducto (@PathVariable int id, Model model){
        ProductoDto productoDto = new ProductoDto();
        Producto producto = new Producto();
        producto = productosService.findById(id);

        productoDto = mapper.fromProductoToDto(producto);
        model.addAttribute("producto", productoDto);

        return "editar-producto";
    }
    @RequestMapping(value="/productosedicion", method= RequestMethod.POST)
    public String update(@ModelAttribute("producto") ProductoDto productoDto){
        // Si en la edición del producto no se importa imagen:
        if ( productoDto.getUrlImagen() == null){
            int id = productoDto.getId();
            Producto productAuxiliar = productosService.findById(id);

            try{
                Producto producto = mapper.fromDtoToDomainWhitoutImage(productoDto);
                producto.setUrlImagen(productAuxiliar.getUrlImagen());
                productosService.edit(producto);
                return "redirect:/productos/list";

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // Si en la edición del producto se importa imagen:
        Producto producto = mapper.fromDtoToDomain(productoDto);
        try{
            productosService.edit(producto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/productos/list";
    }

}