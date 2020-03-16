package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// Jsp와의 연결을 위한 Controller
@Controller
public class DemoController{
    
    // ResponseBody 를 이용해 스프링 정상동작 확인
    @RequestMapping(value="/")
    public String requestMethodName() {
        return "home";
    }
    
    // jsp와 연동을 확인하기 위해 기본페이지가 될 home과의 매핑
    @RequestMapping(value="/home")
    public String next(){
        return "home";
    }
}