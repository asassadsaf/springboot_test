package com.fkp.springboot_condition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class ClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes(ConditionalOnClass.class.getName());
        String[] values = (String[]) map.get("value");
        boolean flag = true;
        try {
            for (String value : values) {
                Class<?> cls = Class.forName(value);
            }
        } catch (ClassNotFoundException e) {
            flag = false;
        }
        return flag;
    }
}
