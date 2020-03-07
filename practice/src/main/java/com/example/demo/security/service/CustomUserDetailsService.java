// Spring Security를 추가한 후 새로 추가한 클래스

// UserDetailsService를 상속받는 구현체
// loadUserByUsername함수는 username을 인자로하여 사용자 존재여부를 판별

package com.example.demo.security.service;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import com.example.demo.security.domain.Member;
import com.example.demo.security.domain.SecurityMember;
import com.example.demo.security.Mapper.UserMapper;
 
@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    private static final String ROLE_PREFIX = "ROLE_";
    
    @Autowired
    UserMapper userMapper;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Member member = userMapper.readUser(username);
        if(member != null) {
            member.setAuthorities(makeGrantedAuthority(userMapper.readAuthority(username)));
        }
        return new SecurityMember(member);
    }
    
    private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        //SimpleGrantedAuthority객체 생성 시 ROLE를 붙여 Spring이 이해할 수 있도록 표현
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
        return list;
    }
 
 
}