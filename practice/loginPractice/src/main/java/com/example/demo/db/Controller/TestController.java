package com.example.demo.db.Controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.example.demo.db.dto.Test;
import com.example.demo.db.service.TestService;
 
@Controller
public class TestController {
 
    @Autowired
    TestService testService;
    
    @RequestMapping("/query")
    public @ResponseBody List<Test> query() throws Exception{
        return testService.getAll();
    }
 
}