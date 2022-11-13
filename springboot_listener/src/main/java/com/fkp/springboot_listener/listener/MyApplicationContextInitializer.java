package com.fkp.springboot_listener.listener;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.ClassPathResource;
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

//        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
//        try {
//            List<PropertySource<?>> externalConfiguration = loader.load("externalConfiguration", new InputStreamResource(new FileInputStream("C:\\Users\\fkp12\\Desktop\\application.yml")));
//            configurableApplicationContext.getEnvironment().getPropertySources().addFirst(externalConfiguration.get(0));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
//        try {
//            factoryBean.setResources(new InputStreamResource(Files.newInputStream(Paths.get("C:\\Users\\fkp12\\Desktop\\application.yml"))));
//            Properties object = factoryBean.getObject();
//            PropertiesPropertySource propertySource = new PropertiesPropertySource("externalConfiguration",object);
//            configurableApplicationContext.getEnvironment().getPropertySources().addFirst(propertySource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
