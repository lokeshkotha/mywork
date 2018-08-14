/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.spring;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
//import sbay.web.requestpojos.CategoryItemsRequest;
//import sbay.web.requestpojos.GenerateSORequest;
//import sbay.web.requestpojos.ItemCartRequest;
//import sbay.web.requestpojos.SalesOrderProductsRequest;
//import sbay.web.requestpojos.SalesOrderRequest;
//import sbay.web.requestpojos.StockCheckRequest;
//import sbay.web.responsepojos.ItemCartData;
//import sbay.web.responsepojos.SalesConfigurationResponse;
//import sbay.web.responsepojos.SalesOrderResponse;
//import sbay.web.responsepojos.ServiceStatus;

/**
 *
 * @author Lokesh Kotha
 */
@Configuration
@PropertySource("classpath:sbay/web/config/config.properties")
public class SalesDAO {

    @Autowired
    public SalesDAO(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        environment = env.getProperty("ENVIRONMENT");
        url = env.getProperty(environment + "_URL");
    }

//    private static final Logger logger = Logger.getLogger(SalesDAO.class.getName());
    private final Environment env;
    private String environment;
    private String url;
    private final String SUCCESS = "Success";
    private final String FAILURE = "Failure";
    private RestTemplate rt;

//    public ServiceStatus addCustomerSalesOrder(SalesOrderRequest salesOrderRequest) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/addcustomersalesorder";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        ServiceStatus serviceStatus = rt.postForObject(URI, salesOrderRequest, ServiceStatus.class);
//        return serviceStatus;
//    }
//
//    public ServiceStatus addCustomerSalesOrderProducts(SalesOrderProductsRequest salesOrderProductsRequest) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/addcustomersalesorderproducts";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        ServiceStatus serviceStatus = rt.postForObject(URI, salesOrderProductsRequest, ServiceStatus.class);
//        return serviceStatus;
//    }
//
//    public SalesOrderResponse getPendingSalesOrderByCustomerId(String customerId) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/getpendingsalesorderbycustomer";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        SalesOrderResponse salesOrderResponse = rt.postForObject(URI, customerId, SalesOrderResponse.class);
//        return salesOrderResponse;
//    }
//
//    public List<Map> getSalesOrderProductsBySalesOrderId(String salesOrderId) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/getsalesorderproductsbysalesorderid";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        List<Map> salesOrderProductsResponseList = rt.postForObject(URI, salesOrderId, List.class);
//        return salesOrderProductsResponseList;
//    }
//
//    public ServiceStatus updateCustomerSalesOrderProducts(SalesOrderProductsRequest salesOrderProductsUpdateRequest) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/updatecustomersalesorderproducts";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        ServiceStatus serviceStatus = rt.postForObject(URI, salesOrderProductsUpdateRequest, ServiceStatus.class);
//        return serviceStatus;
//    }
//
//    public ServiceStatus generateSalesOrder(GenerateSORequest generateSORequest) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/generatesalesorder";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        ServiceStatus serviceStatus = rt.postForObject(URI, generateSORequest, ServiceStatus.class);
//        return serviceStatus;
//    }
//
//    public ServiceStatus checkStockStatus(StockCheckRequest stockCheckRequest) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/checkitemstock";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        ServiceStatus serviceStatus = rt.postForObject(URI, stockCheckRequest, ServiceStatus.class);
//        return serviceStatus;
//    }
//
//    public SalesConfigurationResponse getSalesConfiguration() {
//        String URI = url + "/sales/getsalesconfiguration";
//        rt = new RestTemplate();
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        SalesConfigurationResponse salesConfigurationResponse = rt.getForObject(URI, SalesConfigurationResponse.class);
//        return salesConfigurationResponse;
//    }
//
//    public List<Map> getItemStoreResponseByItem(CategoryItemsRequest categoryItemsRequest) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/getitemstoresbyitem";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        List<Map> itemStoreResponses = rt.postForObject(URI, categoryItemsRequest, List.class);
//        return itemStoreResponses;
//    }
//
//    public ItemCartData getCartItems(ItemCartRequest itemCartRequest) {
//        rt = new RestTemplate();
//        String URI = url + "/sales/getcartitems";
//        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        ItemCartData itemCartData = rt.postForObject(URI, itemCartRequest, ItemCartData.class);
//        return itemCartData;
//    }
// 
}
