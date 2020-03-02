    // Spring Security를 추가한 후 새로 추가한 클래스


package com.example.demo.security.domain;
 
import org.springframework.security.core.userdetails.User;
 
public class SecurityMember extends User{
 
    private static final long serialVersionUID = 1L;
    
    private String ip;
    
    public SecurityMember(Member member) {
        super(member.getUsername(), member.getPassword(), member.getAuthorities());
    }
 
    public String getIp() {
        return ip;
    }
 
    public void setIp(String ip) {
        this.ip = ip;
    }
 
}
