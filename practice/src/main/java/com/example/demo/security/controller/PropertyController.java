package com.example.demo.security.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.security.domain.SecurityMember;
 
@Controller
public class PropertyController {
 
    private Logger LOGGER = LoggerFactory.getLogger(PropertyController.class);
    
    @Value("${logging.path}")
    private String logging_path;
    
    // 앞서 adapter에서 ignore 해놓은 openapi경로의 URL이다.
    @RequestMapping("/openapi/getProperty")
    public @ResponseBody String getProperty(@AuthenticationPrincipal SecurityMember securityMember) {
        
        StringBuffer sb = new StringBuffer();
        
        // 호출할경우 login을 거치지 않기 때문에 SecurityMember 객체를 받아오지 못한다.
        if(securityMember != null) {
            sb.append("securityMember.getIp()=")
                .append(securityMember.getIp())
                .append(" / ");
        }else {
            sb.append("securityMember is null / ");
        }
        sb.append("logging_path=")
            .append(logging_path);
        
        LOGGER.debug(sb.toString());
        
        return sb.toString();
        
    }
    
    // 로그인 이후 접근할 수 있는 getMember URL
    @RequestMapping("/getMember")
    // @AuthenticationPrincipal annotation을 사용하여 SecurityMember를 자동으로 Autowired받아 사용한다.
    public @ResponseBody String getMember(@AuthenticationPrincipal SecurityMember securityMember) {
        
        StringBuffer sb = new StringBuffer();
        
        // 로그인 이후 접근할 수 있으므로 정상적으로 받아온다.
        if(securityMember != null) {
            sb.append("securityMember.getIp()=")
            .append(securityMember.getIp())
            .append(securityMember.getUsername());
        }
        
        // log를 남긴다.
        LOGGER.debug(sb.toString());
        
        // sb -> Member정보를 return한다. ResponseBody annotation을 사용했기 때문에 값을 화면에 보여준다.
        return sb.toString();
        
    }
    
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String referer =request.getHeader("Referer");
        request.getSession().setAttribute("prevPage",referer);
        for(int i=0;i<10;i++){
            System.out.println("이전페이지 : "+request.getSession().getAttribute("prevPage"));
        }

        return "login";
    }

    @RequestMapping("/user/roletest")
    public String role(){
        return "user/roletest";
    }
    @RequestMapping("user/myinfo")
    public String myinfo(){
        return "user/myinfo";
    }

    @RequestMapping("/loginProcessing")
    public String loginProcessing(){
        return "loginProcessing";
    }
    @RequestMapping("/fail")
    public String fail(){
        return "fail";
    }
    
}