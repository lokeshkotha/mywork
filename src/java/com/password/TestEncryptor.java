/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.password;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Lokesh Kotha
 */
public class TestEncryptor {

    public static void main(String[] args) throws Exception {
        TestEncryptor encryptor = new TestEncryptor();
        String text = "Testing@123";
        String encryptedText = encryptor.encrypt(text);
        System.out.println(encryptedText);
        String decrcryptedText = encryptor.decrypt(encryptedText);
        System.out.println(decrcryptedText);
    }

    public String encrypt(String plainText) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // block size is 128bits
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public String decrypt(String encryptedText) throws Exception {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); // block size is 128bits
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] encryptedTextByte = decoder.decode(encryptedText);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
            String decryptedText = new String(decryptedByte);
            return decryptedText;
        } catch (InvalidKeyException e) {
            return "";
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (BadPaddingException e) {
            return "";
        } catch (IllegalBlockSizeException e) {
            return "";
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            System.out.println("Wrong Key");
            return "";
        }
    }
}
