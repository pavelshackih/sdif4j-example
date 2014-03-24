package com.example;

import org.sdif4j.Injector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
public class SpringFacade {

    public static Injector getInjector() {
        return Instance.INSTANCE.injector;
    }

    private enum Instance {
        INSTANCE;

        final Injector injector;

        Instance() {
            ApplicationContext context =
                    new AnnotationConfigApplicationContext(SpringConfiguration.class);
            injector = context.getBean(Injector.class);
        }
    }

    @Configuration
    @ComponentScan(basePackages = {"org.sdif4j", "com.example"})
    static class SpringConfiguration {
    }
}
