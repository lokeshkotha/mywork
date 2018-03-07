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
public class TestJoinMethod1 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        TestJoinMethod1 tjm1 = new TestJoinMethod1();
        TestJoinMethod1 tjm2 = new TestJoinMethod1();
        TestJoinMethod1 tjm3 = new TestJoinMethod1();
        tjm1.start();
        tjm2.start();
        try {
            tjm2.join(500);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        tjm3.start();
    }
}
