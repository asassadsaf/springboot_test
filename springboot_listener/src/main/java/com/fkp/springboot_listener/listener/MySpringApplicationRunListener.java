package com.fkp.springboot_listener.listener;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.InputStreamResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private final SpringApplication springApplication;

    private final String[] args;

    public MySpringApplicationRunListener(SpringApplication springApplication, String[] args) {
        this.springApplication = springApplication;
        this.args = args;
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("SpringApplicationRunListener....starting");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
        try {
            PropertySource<?> propertySource = loader.load("externalConfiguration", new InputStreamResource(Files.newInputStream(Paths.get("C:\\Users\\fkp12\\Desktop\\application.yml")))).get(0);
            environment.getPropertySources().addFirst(propertySource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
