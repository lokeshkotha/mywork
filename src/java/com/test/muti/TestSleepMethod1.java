/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.muti;

/**
 *
 * @author Lokesh Kotha
 */
public class TestSleepMethod1 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        TestSleepMethod1 method1 = new TestSleepMethod1();
        TestSleepMethod1 method2 = new TestSleepMethod1();
        method1.start();
        method2.start();
    }
}
