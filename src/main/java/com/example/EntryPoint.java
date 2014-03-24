package com.example;

import com.example.dao.ISimpleDao;
import org.sdif4j.Injector;

/**
 *
 */
public class EntryPoint implements Runnable {

    public static void main(String[] args) {
        new EntryPoint().run();
    }

    @Override
    public void run() {
        Injector injector = GuiceFacade.getInjector();
        ISimpleDao dao = injector.getInstance(ISimpleDao.class);
        System.out.println(dao.findAll());

//        Injector injector = SpringFacade.getInjector();
//        ISimpleDao dao = injector.getInstance(ISimpleDao.class);
//        System.out.println(dao.findAll());
    }
}
