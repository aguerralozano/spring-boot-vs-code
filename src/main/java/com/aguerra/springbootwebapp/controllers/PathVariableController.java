package com.aguerra.springbootwebapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguerra.springbootwebapp.models.User;
import com.aguerra.springbootwebapp.models.dto.ParamDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("${config.code}")
    private Integer code;

    @GetMapping("/baz/{message}")
    public ParamDto baz( @PathVariable String message ) {

        ParamDto param = new ParamDto();

        param.setMessage(message);

        return param;
    }
    
    @GetMapping("/mix/{message}/{id}")
    public Map<String, Object> mix( 
        @PathVariable String message, 
        @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();

        json.put("message", message);
        json.put("id", id);

        return json;
    }


    @PostMapping("/create")
    public User create(@RequestBody User user) {

        user.setName(user.getName().toUpperCase());
        
        return user;
    }


    @GetMapping("/values")
    public Map<String, Object> values() {

        Map<String, Object> json = new HashMap<>();

        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);

        return json;
    }
    
    
}
