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
public class TestThread extends Thread {

    public void run() {
        System.out.println("thread is running");
    }

    public static void main(String[] args) {
        TestThread testThread=new TestThread();
        testThread.start();
    }
}
