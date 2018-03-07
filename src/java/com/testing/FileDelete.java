/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing;

import java.io.File;

/**
 *
 * @author Lokesh Kotha
 */
public class FileDelete {

    public static void main(String[] args) {
//        String test="http://104.236.106.184:8090/moversfolder/web/bigimages/local-movers1512732804590.png";
//        int index=test.lastIndexOf("/");
//        String out=test.substring(index+1, test.length());
//        System.out.println(out);
        File file = new File("/var/www/html/index.html");

        if (file.delete()) {
            System.out.println(file.getName() + " is deleted!");
        } else {
            System.out.println("Delete operation is failed.");
        }
    }
}
