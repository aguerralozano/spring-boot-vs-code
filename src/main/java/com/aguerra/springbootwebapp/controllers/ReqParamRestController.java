package com.aguerra.springbootwebapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguerra.springbootwebapp.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class ReqParamRestController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(
        required = false, 
        defaultValue = "default message",
        name = "mensaje") String message) {

        //http://localhost:8080/api/params/foo?mensaje=hola
        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(message);

        return paramDto;
    }
    

    @GetMapping("/bar")
    public ParamDto bar(
        @RequestParam() String text,
        @RequestParam() Integer code)  {

        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(text);
        paramDto.setCode(code);

        return paramDto;
    }

    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request)  {

        ParamDto paramDto = new ParamDto();

        Integer code = 0;
        if(request.getParameter("code") != null){
            try {
                code = Integer.parseInt(request.getParameter("code"));
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException -> " + e.getMessage());
            }
        }

        paramDto.setMessage( request.getParameter("text") );
        paramDto.setCode( code );

        return paramDto;
    }
}
