/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author itdev4
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        String unique = String.valueOf(calendar.getTimeInMillis());
        String test1="sklandv-4614";
        String test2=test1.replaceAll("[^a-zA-Z0-9 -]", "");
        String number = "12346579" + unique.toLowerCase().replaceAll("//s", "-");
//        String number2 = number.toLowerCase();
        System.out.println("12346579" + unique.toLowerCase().replaceAll("//s", "-"));
//        Code128 c=new Code128();
//        c.setData("ASESTBR00002");
//        c.setResolution(72);
//        c.drawBarcode("D:\\123\\code1282.png");
//        System.out.println("Success");
//        Date abc = new Date();
//        String filename = "SaleOrder-" + abc.getDay() + abc.getMinutes() + abc.getSeconds();
//        int a = abc.getDay();
//        int b = abc.getMinutes();
//        int h = abc.getSeconds();
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        int d = c.get(Calendar.DAY_OF_WEEK);
//        int e = c.get(Calendar.MINUTE);
//        int f = c.get(Calendar.SECOND);
////        filename = "SaleOrder-" + abc.getDay() + abc.getMinutes() + abc.getSeconds();
//        String filename1 = "SaleOrder-" + c.get(Calendar.DAY_OF_WEEK) + c.get(Calendar.MINUTE) + c.get(Calendar.SECOND);
    }

}
