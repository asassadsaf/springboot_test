package com.fkp.springboot_deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 打包方式：
 *      1.jar包，使用内置Tomcat服务器
 *      2.war包，使用外部Tomcat服务器
 *          需要将pom文件中打包方式改为war包
 *          虚拟地址前需要加文件所在的目录名
 *          将引导类继承SpringBootServletInitializer类并重写configure方法，返回当前引导类的字节码类型
 *
 */

@SpringBootApplication
public class SpringbootDeployApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDeployApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(SpringbootDeployApplication.class);
//    }
}
