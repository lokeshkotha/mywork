/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vib.utilities;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author itdev4
 */
public class Paypal {

    private String paymentId;
    private String state;
    private String quantity;
    private String status;
    private String currencyCode;
    private Map<String, String> sdkConfig;
    private String restApiMerchantId;
    private String restAPIClientId;
    private String restAPIClientSecret;
    private String cancelurl;
    private String returnurl;
    private String url;
    private static String accessToken;
    private static String environment;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Paypal() {

    }

    public void config() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = "com/vib/utilities/paypalconfig.properties";
            Paypal paypal = new Paypal();
            input = paypal.getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }
            prop.load(input);
            String envPrefix = "LIVE_";
            environment = "production";
            if (prop.getProperty("SANDBOX_FLAG").equals("true")) {
                envPrefix = "SANDBOX_";
                environment = "sandbox";
            }
            restApiMerchantId = prop.getProperty("MERCHANT_ID");
            restAPIClientId = prop.getProperty(envPrefix + "CLIENT_ID");
            restAPIClientSecret = prop.getProperty(envPrefix + "CLIENT_SECRET");
            returnurl = prop.getProperty("RETURN_URL");
            cancelurl = prop.getProperty("CANCEL_URL");
            currencyCode = prop.getProperty("CURRENCY_CODE");
        } catch (Exception e) {
            restApiMerchantId = "";
            restAPIClientId = "";
            restAPIClientSecret = "";
            returnurl = "";
            cancelurl = "";
            currencyCode = "";
        }
    }

    public String payMent(String price) throws PayPalRESTException, com.paypal.base.rest.PayPalRESTException, IOException {
        try {
            config();
            sdkConfig = new HashMap<String, String>();
            sdkConfig.put("mode", environment);
            accessToken = new OAuthTokenCredential(restAPIClientId, restAPIClientSecret, sdkConfig).getAccessToken();
            APIContext apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(sdkConfig);

            //set total amount
            Amount amount = new Amount();
            amount.setCurrency(currencyCode);
            amount.setTotal(price);

            //set description for payment
            Transaction transaction = new Transaction();
            transaction.setDescription("creating a payment");

            //setting items list
            List<Item> itemList = new ArrayList<Item>();
            ItemList items = new ItemList();
            Item item = new Item();
            item.setName("Cart");
            item.setQuantity("1");
            item.setPrice(price);
            item.setCurrency(currencyCode);
            itemList.add(item);
            items.setItems(itemList);

            //setting items amount
            transaction.setItemList(items);
            transaction.setAmount(amount);
            List<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(transaction);

            //starting payment 
            Payer payer = new Payer();
            payer.setPaymentMethod("paypal");
            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(transactions);

            //redirection urls
            RedirectUrls redirectUrls = new RedirectUrls();
            redirectUrls.setCancelUrl(cancelurl);
            redirectUrls.setReturnUrl(returnurl);
            payment.setRedirectUrls(redirectUrls);
            Payment createdPayment = payment.create(apiContext);

            //filtering thr approval url from the urls that is returned
            Iterator<Links> links1 = createdPayment.getLinks().iterator();
            while (links1.hasNext()) {
                Links link = links1.next();
                if (link.getRel().equalsIgnoreCase("approval_url")) {
                    //redirecting to payment page
                    url = link.getHref();
                }
            }
        } catch (Exception e) {
            return "";
        }
        return url;
    }

    public Payment lastResponse(String pid, String token, String payerid) throws com.paypal.base.rest.PayPalRESTException, IOException {
        Payment payment = new Payment();
        try {
            sdkConfig = new HashMap<String, String>();
            sdkConfig.put("mode", environment);
            APIContext apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(sdkConfig);
            payment.setId(pid);
            PaymentExecution paymentExecute = new PaymentExecution();
            paymentExecute.setPayerId(payerid);
            payment = payment.execute(apiContext, paymentExecute);
        } catch (Exception e) {
            return null;
        }
        return payment;
    }
}
