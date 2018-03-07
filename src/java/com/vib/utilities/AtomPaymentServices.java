/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vib.utilities;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import sun.misc.BASE64Encoder;

/**
 *
 * @author itdev4
 */
public class AtomPaymentServices {

    private static Integer error;
    private static String login;
    private static String password;
    private static String ttype;
    private static String prodid;
    private static String txncurr;
    private static String returnurl;
    private static String url;

    public void config() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = "com/vib/utilities/atomconfig.properties";
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

            login = prop.getProperty(envPrefix + "login");
            password = prop.getProperty(envPrefix + "password");
            ttype = prop.getProperty(envPrefix + "ttype");
            prodid = prop.getProperty(envPrefix + "prodid");
            txncurr = prop.getProperty(envPrefix + "txncurr");
            returnurl = prop.getProperty("returnurl");
            url = prop.getProperty(envPrefix + "URL");
        } catch (Exception e) {
            login = "";
            password = "";
            ttype = "";
            prodid = "";
            txncurr = "";
            returnurl = "";
        }
    }

    public boolean empty(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, String> getURLParams(PaymentDetails details) throws UnsupportedEncodingException {
        Map<String, String> urlParams = new HashMap<String, String>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String CurrDateTime = sdf.format(new Date()).toString();
        String b64ClientCode = new BASE64Encoder().encode(details.getClientcode().getBytes("UTF-8"));
        try {
            error = 0;
            config();
            urlParams.put("login", login);
            urlParams.put("pass", password);
            urlParams.put("ttype", ttype);
            urlParams.put("prodid", prodid);
            urlParams.put("amt", details.getAmount());
            urlParams.put("txncurr", txncurr);
            urlParams.put("txnscamt", "0");
            urlParams.put("clientcode", b64ClientCode);
            urlParams.put("txnid", details.getTxnid());
            urlParams.put("date", CurrDateTime);
            urlParams.put("custacc", details.getCustacc());
            urlParams.put("ru", returnurl);
            urlParams.put("url", url);
            urlParams.put("udf1", details.getFirstname());
            urlParams.put("udf2", details.getEmail());
            urlParams.put("udf3", details.getPhone());
            for (Map.Entry<String, String> entry : urlParams.entrySet()) {
                if (empty(entry.getValue())) {
                    error = 1;
                }
            }
//        urlParams.put("mdd", null);
//        urlParams.put("udf1", "");
            if (error == 0) {
                return urlParams;
            } else {
                urlParams.clear();
                return urlParams;
            }
        } catch (Exception e) {
            urlParams.clear();
            return urlParams;
        }
    }
}
