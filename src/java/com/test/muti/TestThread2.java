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
public class TestThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {
        TestThread2 testThread2 = new TestThread2();
        Thread t1 = new Thread(testThread2);
        t1.start();
    }
}
