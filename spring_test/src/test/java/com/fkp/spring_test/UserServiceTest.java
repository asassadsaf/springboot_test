package com.fkp.spring_test;

import com.fkp.spring_test.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //测试类在SpringTestApplicationTest.java所在的包及其子包下时，无需指定该注解的classes属性
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        userService.save();
    }
}
