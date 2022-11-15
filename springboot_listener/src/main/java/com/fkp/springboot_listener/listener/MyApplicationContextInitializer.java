package com.fkp.springboot_listener.listener;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.InputStreamResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
        try {
            PropertySource<?> propertySource = loader.load("externalConfiguration", new InputStreamResource(Files.newInputStream(Paths.get("C:\\Users\\fkp12\\Desktop\\application.yml")))).get(0);
            configurableApplicationContext.getEnvironment().getPropertySources().addFirst(propertySource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//
//    YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
//        try {
//                factoryBean.setResources(new InputStreamResource(Files.newInputStream(Paths.get("C:\\Users\\fkp12\\Desktop\\application.yml"))));
//                Properties object = factoryBean.getObject();
//                if(object != null){
//                PropertiesPropertySource propertySource = new PropertiesPropertySource("publicConfiguration",object);
//                configurableApplicationContext.getEnvironment().getPropertySources().addFirst(propertySource);
//                }
//                } catch (IOException e) {
//                e.printStackTrace();
//                }
//
//                PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();
//                try {
//                PropertySource<?> propertySource = loader.load("publicConfiguration", new InputStreamResource(Files.newInputStream(Paths.get("C:\\Users\\fkp12\\Desktop\\application.properties")))).get(0);
//        configurableApplicationContext.getEnvironment().getPropertySources().addFirst(propertySource);
//        } catch (IOException e) {
//        throw new RuntimeException(e);
//        }
//
//
//        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
//        try {
//        factoryBean.setLocation(new InputStreamResource(Files.newInputStream(Paths.get("C:\\Users\\fkp12\\Desktop\\application.properties"))));
//        Properties object = factoryBean.getObject();
//        if(object != null){
//        PropertiesPropertySource propertySource = new PropertiesPropertySource("publicConfiguration",object);
//        configurableApplicationContext.getEnvironment().getPropertySources().addFirst(propertySource);
//        }
//        } catch (IOException e) {
//        throw new RuntimeException(e);
//        }
