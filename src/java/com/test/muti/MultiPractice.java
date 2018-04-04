/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.muti;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lokesh
 */
public class MultiPractice implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread Running Started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(MultiPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread Running");
    }
    public static void main(String[] args) throws InterruptedException {
        MultiPractice mp=new MultiPractice();
        Thread t=new Thread(mp);
        t.start();
//        t.join();
        Thread t2=new Thread(new MultiPractice());
        t2.start();
//        t2.join();
    }
}
