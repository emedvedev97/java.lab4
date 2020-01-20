/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.lab4;

import java.io.*;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emedvedev
 */
public class MyClassLoader extends ClassLoader  {
    
    
     @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        
        String path = "/classes/" + name.replace('.', '/');
        
        String classDirectory = null;
         try {
             File currentClass = new File(URLDecoder.decode(App.class
                     .getProtectionDomain()
                     .getCodeSource()
                     .getLocation()
                     .getPath(), "UTF-8"));
             classDirectory = currentClass.getParent() + path;
         } catch (UnsupportedEncodingException ex) {
             Logger.getLogger(MyClassLoader.class.getName()).log(Level.SEVERE, null, ex);
         }

        System.out.println(classDirectory);
        File f = new File(classDirectory + ".class");
        if(!f.isFile())
            throw new ClassNotFoundException("Нет такого класса " + name);
        try{
            InputStream ins = new BufferedInputStream(new FileInputStream(f));
            byte[] b = new byte[(int)f.length()];
            ins.read(b);
            Class c = defineClass(name, b, 0, b.length);
            return c;
        }catch (IOException e){
            throw new ClassNotFoundException("Проблемы с байт кодом");
        }
    }  
}
