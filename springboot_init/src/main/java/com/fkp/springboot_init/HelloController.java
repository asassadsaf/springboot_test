package com.fkp.springboot_init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class    HelloController {

    //使用@Value注解获取配置文件中的属性值
    @Value("${name}")
    private String name1;
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;
    @Value("${address[0]}")
    private String address1;
    @Value("${address[1]}")
    private String address2;
    @Value("${msg1}")
    private String msg1;
    @Value("${msg2}")
    private String msg2;

    //使用Environment对象获取配置文件中的属性值
    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @RequestMapping("/hello2")
    public String hello2(){
        System.out.println(name1);
        System.out.println(name);
        System.out.println(age);
        System.out.println(address1);
        System.out.println(address2);
        System.out.println(msg1);
        System.out.println(msg2);

        System.out.println("-----------------------------------");

        String address1 = env.getProperty("address[0]");
        String msg1 = env.getProperty("msg1");
        String age = env.getProperty("person.age");
        System.out.println(address1);
        System.out.println(msg1);
        System.out.println(age);

        System.out.println("-----------------------------------");

        System.out.println(person);
        String[] address = person.getAddress();
        for (String s : address) {
            System.out.println(s);
        }

        return "success!";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello Spring Boot!!";
    }
}
