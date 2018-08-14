/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Lokesh Kotha
 */
public class GlobalConfiguration {

    private static GlobalConfiguration instance;
    public static String defaultStoreId;

    private GlobalConfiguration() {
        initializeConfigurationData();
    }

    public static GlobalConfiguration getInstance() {
        if (instance == null) {
            synchronized (GlobalConfiguration.class) {
                if (instance == null) {
                    instance = new GlobalConfiguration();
                }
            }
        }
        return instance;
    }

    private void initializeConfigurationData() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SalesDAO.class);
        SalesDAO salesDAO = (SalesDAO) ctx.getBean("salesDAO");
//        SalesConfigurationResponse salesConfigurationResponse = salesDAO.getSalesConfiguration();
//        defaultStoreId = salesConfigurationResponse.getDefaultStoreId();
    }
}
