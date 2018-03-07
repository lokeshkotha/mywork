/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.testing;

import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author Lokesh Kotha
 */
public class StringMethod {

    public static void main(String[] args) {
//        "testing2"+();
    }

    public void testing2() {
//        System.out.println("testing 2 is called");
//        import java.lang.reflect.*;
//
//Method method = obj.getClass().getMethod(methodName);
//
//then invoke it with method.invoke(obj, arg1, arg2);

        //String parameter
        Method method;
        Class[] paramList = new Class[1];
        paramList[0] = List.class;
//        method = textFormatTemplates.getClass().getMethod(partnersObj.getTemplateName(), paramList);
//        Leads leads = (Leads) method.invoke(textFormatTemplates, dataList);

    }
}
