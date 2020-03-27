package com.thoughtworks.parkinglot.common.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author gitqh
 */
@Configuration
public class SpringContextConfig implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        SpringContextConfig.applicationContext = applicationContext;
    }

    public static Object getBean(final String name) {
        return applicationContext.getBean(name);
    }
}
