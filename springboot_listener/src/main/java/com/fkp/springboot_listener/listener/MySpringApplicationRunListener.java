package com.fkp.springboot_listener.listener;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.InputStreamResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("SpringApplicationRunListener....starting");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        try {
            factoryBean.setResources(new InputStreamResource(Files.newInputStream(Paths.get("C:\\Users\\fkp12\\Desktop\\application.yml"))));
            Properties object = factoryBean.getObject();
            PropertiesPropertySource propertySource = new PropertiesPropertySource("externalConfiguration",object);
            environment.getPropertySources().addFirst(propertySource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("SpringApplicationRunListener....environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener....contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener....contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener....started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener....running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("SpringApplicationRunListener....failed");
    }
}
