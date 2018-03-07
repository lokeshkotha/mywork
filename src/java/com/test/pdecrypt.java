/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.security.MessageDigest;

/**
 * 6012cf150853b745ba189ec11cfdf96e03d60672
 *
 * @author itdev8
 */
public class pdecrypt {

    public static void main(String[] args) {
        String password = "abc1234";
        String algorithm = "SHA";

        byte[] plainText = password.getBytes();

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }

        md.reset();
        md.update(plainText);
        byte[] encodedPassword = md.digest();
        

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                sb.append("0");
            }

            sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }

        System.out.println("Plain    : " + password);
        System.out.println("Encrypted: " + sb.toString());
    }
}
