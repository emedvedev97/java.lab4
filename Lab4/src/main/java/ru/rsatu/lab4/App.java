/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.lab4;

import java.io.IOException;
import java.lang.reflect.Proxy;
import javassist.CannotCompileException;
import javassist.NotFoundException;

/**
 *
 * @author emedvedev
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NotFoundException, CannotCompileException, IOException, InstantiationException, IllegalAccessException {
        Demo ad = (Demo)Proxy.newProxyInstance(AnnotationDemo.class.getClassLoader(),
                                                 AnnotationDemo.class.getInterfaces(),
                                                 new CustomInvocationHandler(new AnnotationDemo()));
        ad.setId(Long.MIN_VALUE);
        System.out.println(ad.getId());
        // TODO code application logic here
        Info info = new Info();
        String out = info.getAllInfo(AnnotationDemo.class);
        System.out.println("Class info:");
        System.out.println(out);
    }

}
