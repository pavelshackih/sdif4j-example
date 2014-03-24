package com.example;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import org.sdif4j.Injector;

/**
 *
 */
public class GuiceFacade {

    public static Injector getInjector() {
        return Instance.INSTANCE.injector;
    }

    private static class SimpleModule extends AbstractModule {

        @Override
        protected void configure() {
        }
    }

    private enum Instance {

        INSTANCE;

        final Injector injector;

        Instance() {
            com.google.inject.Injector googleInjector = Guice.createInjector(new SimpleModule());
            injector = googleInjector.getInstance(Injector.class);
        }
    }
}
