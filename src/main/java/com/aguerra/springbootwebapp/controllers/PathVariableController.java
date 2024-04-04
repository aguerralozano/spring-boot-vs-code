package com.aguerra.springbootwebapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguerra.springbootwebapp.models.User;
import com.aguerra.springbootwebapp.models.dto.ParamDto;




@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    // @Value("${config.message}")
    // private String message;

    // @Value("${config.listOfValues}")
    // private String[] listOfValues;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',') }")
    private List<String> valuesString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Autowired
    private Environment environment;

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
    public Map<String, Object> values(
        @Value("${config.message}") String message
    ) {

        Map<String, Object> json = new HashMap<>();


        json.put("username", username);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code", code);
        json.put("code2", environment.getProperty("config.code", Long.class));

        json.put("listOfValues", listOfValues);
        json.put("valuesString", valuesString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);

        
        return json;
    }
    
    
}
