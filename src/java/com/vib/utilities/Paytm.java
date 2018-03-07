/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vib.utilities;

import com.paytm.merchant.CheckSumServiceHelper;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author itdev4
 */
public class Paytm {

    private static String MID;
    private static String MERCHANT_KEY;
    private static String CALLBACK_URL;
    private static String INDUSTRY_TYPE_ID;
    private static String CHANNEL_ID;
    private static String WEBSITE;
    private static String PAYTM_URL;

    public Paytm() {
    }

    public void config() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = "com/vib/utilities/paytmconfig.properties";
            Paytm p = new Paytm();
            input = p.getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
            }
            prop.load(input);
            String envPrefix = "LIVE_";
            if (prop.getProperty("SANDBOX_FLAG").equals("true")) {
                envPrefix = "SANDBOX_";
            }
            MID = prop.getProperty(envPrefix + "MID");
            MERCHANT_KEY = prop.getProperty(envPrefix + "MERCHANT_KEY");
            PAYTM_URL = prop.getProperty(envPrefix + "PAYTM_URL");
            CALLBACK_URL = prop.getProperty("CALLBACK_URL");
            INDUSTRY_TYPE_ID = prop.getProperty("INDUSTRY_TYPE_ID");
            CHANNEL_ID = prop.getProperty("CHANNEL_ID");
            WEBSITE = prop.getProperty("WEBSITE");
        } catch (Exception e) {
            MID = "";
            MERCHANT_KEY = "";
            PAYTM_URL = "";
            CALLBACK_URL = "";
            INDUSTRY_TYPE_ID = "";
            CHANNEL_ID = "";
            WEBSITE = "";
        }
    }

    public Map<String, String> initiatePayment(String mobile, String email,String amount) throws Exception {
        config();
        TreeMap<String, String> parameters = new TreeMap<String, String>();
        String ORDER_ID="";
        String CUST_ID="";
        String TXN_AMOUNT=amount;
        try {
             //generating transaction id
            Random rand = new Random();
            String rndm = Integer.toString(rand.nextInt()) + (System.currentTimeMillis() / 1000L);
            ORDER_ID = rndm;
            CUST_ID="001";
            parameters.put("ORDER_ID", ORDER_ID);
            parameters.put("CUST_ID", CUST_ID);
            parameters.put("MID", MID);
            parameters.put("TXN_AMOUNT", TXN_AMOUNT);
            parameters.put("CHANNEL_ID", CHANNEL_ID);
            parameters.put("INDUSTRY_TYPE_ID", INDUSTRY_TYPE_ID);
            parameters.put("WEBSITE", WEBSITE);
            parameters.put("MOBILE_NO", mobile);
            parameters.put("EMAIL", email);
            parameters.put("CALLBACK_URL", CALLBACK_URL);
            String checkSum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MERCHANT_KEY, parameters);
            parameters.put("checkSum", checkSum);
            parameters.put("PAYTM_URL", PAYTM_URL);
            return parameters;
        } catch (Exception e) {
            parameters.clear();
            return parameters;
        }
    }

}
