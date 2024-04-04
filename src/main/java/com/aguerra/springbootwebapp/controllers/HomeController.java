package com.aguerra.springbootwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping({"", "/", "/home"})
    public String home() {
        //return "redirect:/list"; //cambiar la url y reinicia el request
        return "forward:/list"; //se mantiene dentro de la peticion http
    }
    
}
