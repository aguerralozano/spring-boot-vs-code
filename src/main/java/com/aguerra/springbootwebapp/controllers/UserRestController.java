package com.aguerra.springbootwebapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/api/v1")
public class UserRestController {
    
    @GetMapping("/details-rest")
    @ResponseBody
    public Map<String, Object> details(){
        Map<String, Object> body = new HashMap<>();

        body.put("title", 
            "Hola mundo");
        body.put("name", 
            "Angel");
        body.put("lastName", 
            "Guerra");
        return body;
    }
}
