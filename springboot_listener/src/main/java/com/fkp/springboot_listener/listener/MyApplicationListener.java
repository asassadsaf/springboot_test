package com.fkp.springboot_listener.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.InputStreamResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
        try {
            PropertySource<?> propertySource = loader.load("externalConfiguration", new InputStreamResource(Files.newInputStream(Paths.get("C:\\Users\\fkp12\\Desktop\\application.yml")))).get(0);
            applicationEnvironmentPreparedEvent.getEnvironment().getPropertySources().addFirst(propertySource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
