package com.example.demo.security.Mapper;
import com.example.demo.security.domain.Member; 
import java.util.List;
 
public interface UserMapper {
 
    public Member readUser(String username);
 
    public List<String> readAuthority(String username);
}