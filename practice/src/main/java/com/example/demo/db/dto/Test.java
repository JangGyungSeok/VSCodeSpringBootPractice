package com.example.demo.db.dto;
 

// Database의 정보를 받아올 객체이다.
// DB의 테이블과 형태가 똑같아야한다!!!
public class Test {
 
    private String ID;
    
    private String Password;
 
    public String getID() {
        return ID;
    }
 
    public void setID(String id) {
        this.ID = id;
    }
 
    public String getPassword() {
        return Password;
    }
 
    public void setPassowrd(String password) {
        this.Password = password;
    }
    
    
}