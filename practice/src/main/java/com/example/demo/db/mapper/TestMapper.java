package com.example.demo.db.mapper;
 
import java.util.List;
 
import com.example.demo.db.dto.Test;


// Mapper이다. 그저 interface로 정의한다.
// interface로 정의된 mapper는 service와의 의존성이 있다.
public interface TestMapper {
 
    public List<Test> getAll() throws Exception;
    
}
