package com.tiendavirtual.controller;

import com.tiendavirtual.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/auth/login", method = RequestMethod.GET)
    public String login(){ return "login";}







 /*   @RequestMapping(value="/login", method= RequestMethod.POST)
    public String comprobarLogin(@RequestParam String usuario, @RequestParam String password){
        if (userService.Login(usuario,password)){
           return "Home";
        }else return "ErrorLogin";
    }*/

}
