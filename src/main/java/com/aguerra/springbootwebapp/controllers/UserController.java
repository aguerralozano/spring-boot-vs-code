package com.aguerra.springbootwebapp.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.aguerra.springbootwebapp.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Map<String, Object> model) {
        User user = new User("Angel", "Guerra");

        model.put("title",
                "Hola mundo");
        model.put("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {

        User user1 = new User("Angel", "Guerra", "aguerralozano@gmail.com");
        User user2 = new User("Jhon", "Kelvin");
        User user3 = new User("Brian", "Ocnoner");

        return Arrays.asList(user1, user2, user3);
    }


    // @GetMapping("/list")
    // public String list(ModelMap model){

    // User user1 = new User("Angel", "Guerra", "aguerralozano@gmail.com");
    // User user2 = new User("Jhon", "Kelvin");
    // User user3 = new User("Brian", "Ocnoner");

    // List<User> users = Arrays.asList(user1, user2, user3);
    // model.put("users", users);

    // return "list";
    // }

    // @GetMapping("/details")
    // public String details(Model model){
    // model.addAttribute("title",
    // "Hola mundo");
    // model.addAttribute("name",
    // "Angel");
    // model.addAttribute("lastName",
    // "Guerra");
    // return "details";
    // }
}
