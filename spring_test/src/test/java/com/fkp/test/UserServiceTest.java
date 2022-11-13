package com.fkp.test;

import com.fkp.spring_test.SpringTestApplication;
import com.fkp.spring_test.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//测试的类不在springboot自动创建的SpringTestApplicationTest.java的包或其子包下时需要指定启动类.class，即SpringTestApplication.class
@SpringBootTest(classes = SpringTestApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        userService.save();
    }
}
