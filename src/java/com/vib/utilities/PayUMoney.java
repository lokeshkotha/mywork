/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vib.utilities;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author itdev4
 */
public class PayUMoney {

    private static Integer error;
    private static String key;
    private static String salt;
    private static String successurl;
    private static String failureurl;
    private static String url;
    private static String serviceprovider;

    public void config() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = "com/vib/utilities/payumoneyconfig.properties";
            PayUMoney payu = new PayUMoney();
            input = payu.getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
            }
            prop.load(input);
            String envPrefix = "LIVE_";
            if (prop.getProperty("SANDBOX_FLAG").equals("true")) {
                envPrefix = "SANDBOX_";
            }
            key = prop.getProperty(envPrefix + "KEY");
            salt = prop.getProperty(envPrefix + "SALT");
            successurl = prop.getProperty("SUCCESS_URL");
            failureurl = prop.getProperty("FAILURE_URL");
            url = prop.getProperty(envPrefix + "URL");
            serviceprovider = prop.getProperty("SERVICE_PROVIDER");
        } catch (Exception e) {
            key = "";
            salt = "";
            successurl = "";
            failureurl = "";
            url = "";
            serviceprovider = "";
        }
    }

//    method to check whether the value is empty or not or equals null
    public boolean empty(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        } else {
            return false;
        }
    }

//    method to generate secure hashcode and to fetch urlparameters
    public String hashCal(String type, String str) {
        byte[] hashseq = str.getBytes();
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest algorithm = MessageDigest.getInstance(type);
            algorithm.reset();
            algorithm.update(hashseq);
            byte messageDigest[] = algorithm.digest();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }

        } catch (NoSuchAlgorithmException nsae) {
        }
        return hexString.toString();
    }

    public Map<String, String> hashCalMethod(PaymentDetails details) {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> urlParams = new HashMap<String, String>();
        try {
            error = 0;
            config();
            params.put("key", key);
            params.put("surl", successurl);
            params.put("furl", failureurl);
            params.put("amount", details.getAmount().toString());
            params.put("firstname", details.getFirstname());
            params.put("email", details.getEmail());
            params.put("phone", details.getPhone());
            params.put("productinfo", details.getProductinfo());
            params.put("service_provider", serviceprovider);
            String hashString = "";
            String txnid = "";

            //generating transaction id
            Random rand = new Random();
            String rndm = Integer.toString(rand.nextInt()) + (System.currentTimeMillis() / 1000L);
            txnid = rndm;
            params.remove("txnid");
            params.put("txnid", txnid);
            txnid = hashCal("SHA-256", rndm).substring(0, 20);

            String hash = "";
            String otherPostParamSeq = "phone|surl|furl|lastname|curl|address1|address2|city|state|country|zipcode|pg";
            String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";
            if (empty(params.get("hash")) && params.size() > 0) {
                if (empty(params.get("key")) || empty(txnid) || empty(params.get("amount")) || empty(params.get("firstname")) || empty(params.get("email")) || empty(params.get("phone")) || empty(params.get("productinfo")) || empty(params.get("surl")) || empty(params.get("furl")) || empty(params.get("service_provider"))) {
                    error = 1;
                } else {
                    String[] hashVarSeq = hashSequence.split("\\|");
                    for (String part : hashVarSeq) {
                        if (part.equals("txnid")) {
                            hashString = hashString + txnid;
                            urlParams.put("txnid", txnid);
                        } else {
                            hashString = (empty(params.get(part))) ? hashString.concat("") : hashString.concat(params.get(part).trim());
                            urlParams.put(part, empty(params.get(part)) ? "" : params.get(part).trim());
                        }
                        hashString = hashString.concat("|");
                    }
                    hashString = hashString.concat(salt);
                    hash = hashCal("SHA-512", hashString);
                    String[] otherPostParamVarSeq = otherPostParamSeq.split("\\|");
                    for (String part : otherPostParamVarSeq) {
                        urlParams.put(part, empty(params.get(part)) ? "" : params.get(part).trim());
                    }
                }
            }
            urlParams.put("hash", hash);
            urlParams.put("hashString", hashString);
            urlParams.put("action", url);
            urlParams.put("service_provider", serviceprovider);
        } catch (Exception e) {
            urlParams.clear();
            return urlParams;
        }
        if (error == 0) {
            return urlParams;
        } else {
            urlParams.clear();
            return urlParams;
        }
    }
}
