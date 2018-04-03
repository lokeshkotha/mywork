/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.test;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Lokesh Kotha
 */
public class DateTest {

    public static void main(String[] args) {
        Date date=new Date();
        int leadLimitDays = 30;
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        cal1.add(Calendar.DATE, leadLimitDays);
        Date moveDate=cal1.getTime();
        Boolean status;
        if (leadLimitDays == 0) {
            status = Boolean.TRUE;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, leadLimitDays);
            if (moveDate.before(cal.getTime())) {
                status = Boolean.TRUE;
            } else {
                status = Boolean.FALSE;
            }
        }
        System.out.println(status);
    }

}
