package com.aguerra.springbootwebapp.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aguerra.springbootwebapp.models.User;
import com.aguerra.springbootwebapp.models.dto.UserDto;

@RestController
@RequestMapping("/api/v2")
public class UserRest2Controller {

    @GetMapping("/details-rest")
    public UserDto details() {

        UserDto userDto = new UserDto();
        User user = new User("Angel", "Guerra");
        userDto.setUser(user);
        userDto.setTitle("Hola mundo details-rest");
        return userDto;
    }

    @GetMapping("/list-rest")
    public List<User> list() {

        User user1 = new User("Angel", "Guerra");
        User user2 = new User("Jhon", "Kelvin");
        User user3 = new User("Brian", "Ocnoner");

        List<User> users = Arrays.asList(user1, user2, user3);

        // List<User> users = new ArrayList<User>();
        // users.add(user1);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

    // @GetMapping("/details-rest")
    @RequestMapping(path = "/details-rest-map", method = RequestMethod.GET)
    public Map<String, Object> detailsMap() {

        User user = new User("Angel", "Guerra");

        Map<String, Object> body = new HashMap<>();

        body.put("title",
                "Hola mundo details-rest-map");
        body.put("user", user);
        return body;
    }
}
