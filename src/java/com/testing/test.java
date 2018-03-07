/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Lokesh Kotha
 */
public class test {

    public static void main(String[] args) {
        try {
//            String testxml = "<?xml version='1.0'?><AAA><BBB><leadid>24766584</leadid><errid>0</errid><msg>OK</msg><sold>1</sold><match>1</match><ordno>574312</ordno></BBB></AAA>"
//                    + "<?xml version='1.0'?><AAA><BBB><leadid>24766584</leadid><errid>0</errid><msg>OK</msg><sold>1</sold><match>1</match><ordno>574312</ordno></BBB></AAA>";
////            String[] splist = testxml.split("<?xml version='1.0'?>");
////            if (splist.length != 0) {
////                String finalXML = splist[0].substring(0, testxml.lastIndexOf("?") - 1);
////                System.out.println(finalXML);
////            }
//            String finalXML = testxml.substring(0, testxml.lastIndexOf("<?xml version='1.0'?>"));
//            System.out.println(finalXML);
//            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
            Date startDate = sdf2.parse(sdf2.format(new Date()));
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            cal.add(Calendar.HOUR_OF_DAY, 23);
            cal.add(Calendar.MINUTE, 59);
            cal.add(Calendar.SECOND, 59);
            Date endDate = cal.getTime();
            System.out.println(startDate);
            System.out.println(endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
