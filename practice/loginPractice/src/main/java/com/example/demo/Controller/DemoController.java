package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DemoController{

    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public String requestMethodName() {
        return "Hello Spring Boot";
    }
    
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String next(){
        return"home";
    }
}