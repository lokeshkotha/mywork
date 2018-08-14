/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 *
 * @author Lokesh Kotha
 */
//@Component
public class StartupListener implements
        ApplicationListener<ContextRefreshedEvent> {

    public static String defaultStoreId;

    @Autowired
    public StartupListener(SalesDAO salesDAO) {
        this.salesDAO = salesDAO;
    }

    private final SalesDAO salesDAO;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
//        SalesConfigurationResponse salesConfigurationResponse = salesDAO.getSalesConfiguration();
//        defaultStoreId = salesConfigurationResponse.getDefaultStoreId();
    }
}
