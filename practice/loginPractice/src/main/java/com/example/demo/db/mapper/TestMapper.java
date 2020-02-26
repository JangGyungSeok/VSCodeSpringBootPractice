package com.example.demo.db.mapper;
 
import java.util.List;
 
import com.example.demo.db.dto.Test;
import org.springframework.context.annotation.Bean;

public interface TestMapper {
 
    public List<Test> getAll() throws Exception;
    
}
