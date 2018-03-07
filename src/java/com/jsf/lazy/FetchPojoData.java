/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.lazy;

import java.lang.reflect.Field;

/**
 *
 * @author Lokesh Kotha
 */
public class FetchPojoData {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        int sum = 0;
        Employee employee = new Employee();
        Field[] allFields = employee.getClass().getDeclaredFields();

        for (Field each : allFields) {

            if (each.getType().toString().equals("int")) {

                Field field = employee.getClass().getDeclaredField(each.getName());
                field.setAccessible(true);

                Object value = field.get(employee);
                Integer i = (Integer) value;
                sum = sum + i;
            }

        }

        System.out.println("Sum :" + sum);
    }

}
