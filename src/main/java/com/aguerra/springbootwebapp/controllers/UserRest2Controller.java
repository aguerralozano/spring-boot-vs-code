package com.aguerra.springbootwebapp.controllers;

import java.util.HashMap;
import java.util.Map;

// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aguerra.springbootwebapp.models.User;



@RestController
@RequestMapping("/api/v2")
public class UserRest2Controller {
    
    // @GetMapping("/details-rest")
    @RequestMapping(path = "/details-rest", method = RequestMethod.GET)
    public Map<String, Object> details(){

        User user = new User("Angel", "Guerra");

        Map<String, Object> body = new HashMap<>();

        body.put("title", 
            "Hola mundo");
        body.put("user", user);
        return body;
    }
}
