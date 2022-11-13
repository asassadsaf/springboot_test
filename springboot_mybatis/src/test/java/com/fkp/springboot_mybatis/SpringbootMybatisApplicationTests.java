package com.fkp.springboot_mybatis;

import com.fkp.springboot_mybatis.domain.User;
import com.fkp.springboot_mybatis.mapper.UserMapper;
import com.fkp.springboot_mybatis.mapper.UserXMLMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXMLMapper userXMLMapper;

    @Test
    public void test() {
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void test2(){
        List<User> userList = userXMLMapper.findAll2();
        System.out.println(userList);
    }

}
