package com.aguerra.springbootwebapp.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aguerra.springbootwebapp.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Map<String, Object> model){
        User user = new User("Angel", "Guerra");

        model.put("title", 
            "Hola mundo");
        model.put("user", user);
        return "details";
    }
    
    // @GetMapping("/details")
    // public String details(Model model){
    //     model.addAttribute("title", 
    //         "Hola mundo");
    //     model.addAttribute("name", 
    //         "Angel");
    //     model.addAttribute("lastName", 
    //         "Guerra");
    //     return "details";
    // }
}
