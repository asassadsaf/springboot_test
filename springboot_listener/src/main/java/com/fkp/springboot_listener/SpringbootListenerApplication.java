package com.fkp.springboot_listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 监听器接口：
 *      1.ApplicationContextInitializer，需要在配置文件中配置,resources下的META-INF/spring.factories
 *      2.SpringApplicationRunListener，需要在配置文件中配置,resources下的META-INF/spring.factories，需要有参构造
 *      3.CommandLineRunner,只需要把实现类加入到IOC容器中就可以自动执行
 *      4.ApplicationRunner，只需要把实现类加入到IOC容器中就可以自动执行
 */


@SpringBootApplication
public class SpringbootListenerApplication {

    private static String name;


    private static ApplicationContext applicationContext;

    @Autowired
    private void setApplicationContext(ApplicationContext applicationContext) {
        SpringbootListenerApplication.applicationContext = applicationContext;
    }

    @Value("${name}")
    private void setName(String name){
        SpringbootListenerApplication.name = name;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootListenerApplication.class, args);
        System.out.println(name);
        String value = applicationContext.getEnvironment().getProperty("name");
        System.out.println(value);
    }

}
