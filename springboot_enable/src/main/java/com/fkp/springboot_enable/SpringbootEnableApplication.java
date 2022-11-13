package com.fkp.springboot_enable;


import com.fkp.config.MyImportBeanDefinitionRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @ComponentScan 扫描范围;当前引导类所在包以及子包，即com.fkp.springboot_enable.SpringbootEnableApplication
 * SpringBoot如何获取jar包中定义的Bean
 *      首先需要在pom文件中添加对应的依赖
 *      1.使用@ComponentScan扫描配置类所在的包，即com.fkp.config
 *      2.使用@Import注解，加载类，这些类都会被Spring创建并放入IOC容器
 *      3.可以对@Import注解进行封装。即在引入的工程项目下创建自定义的EnableUser注解，其中添加@Import注解并加载配置类，添加Import注解中的原注解
 */

/**
 * @Import的四种用法：
 *      1.导入Bean
 *      2.导入配置类，配置类可以不加@Configuration注解
 *      3.导入ImportSelector的实现类
 *      4.导入ImportBeanDefinitionRegistrar的实现类
 */
@SpringBootApplication
//@ComponentScan("com.fkp.config")
//@Import(UserConfig.class)
//@EnableUser

//@Import(User.class)
//@Import(UserConfig.class)
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

//        Object user = context.getBean("user");
//        System.out.println(user);

//        Map<String, User> map = context.getBeansOfType(User.class);
//        System.out.println(map);
//        Object user = context.getBean("com.fkp.domain.User");
//        System.out.println(user);

//        Object user = context.getBean("user");
//        Object role = context.getBean("role");
//        System.out.println(user+"\n"+role);

//        User user = context.getBean(User.class);
//        Role role = context.getBean(Role.class);
//        System.out.println(user+"\n"+role);
//
//        Object user1 = context.getBean("user");
//        Object role1 = context.getBean("role");
//        System.out.println(user1+"\n"+role1);

        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis);

        jedis.set("name","fkp");
        String name = jedis.get("name");
        System.out.println(name);

    }

//    @Bean
//    public Jedis jedis(){
//        return new Jedis("localhost",6379);
//    }
}
