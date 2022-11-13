package com.fkp.springboot_condition.config;

import com.fkp.springboot_condition.condition.ClassCondition;
import com.fkp.springboot_condition.condition.ConditionalOnClass;
import com.fkp.springboot_condition.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
//    @Conditional(ClassCondition.class)
    @ConditionalOnClass("redis.clients.jedis.Jedis")
    public User user(){
        return new User();
    }

    @Bean
    @ConditionalOnProperty(name = "username",havingValue = "fkp")
    public User user2(){
        return new User();
    }
}
