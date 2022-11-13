package com.fkp.test;

import com.fkp.domain.User;
import com.fkp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MPTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}
