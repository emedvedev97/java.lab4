/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.lab4;

/**
 *
 * @author emedvedev
 */

public class AnnotationDemo implements Demo {
    private Long id;
    
    @Override
    @Logged(value = LogType.ERROR, loggedClass = AnnotationDemo.class)
    public Long getId() {
        return id;
    }

    @Override
    @Logged(value = LogType.INFO, loggedClass = AnnotationDemo.class)
    public void setId(Long id) {
        this.id = id;
    }
    
}
