///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.jsf.lazy;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Map;
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import org.primefaces.model.LazyDataModel;
//import org.primefaces.model.SortOrder;
//
///**
// *
// * @author Lokesh Kotha
// */
//@ManagedBean
//@ViewScoped
//public class InventoryManagerMB implements Serializable {
//
//    private static final long serialVersionUID = -1201944101993687165L;
//
//    @EJB
//    private InventoryManagerEJB inventoryManagerEJB;
//
//    private LazyDataModel<Site> model;
//
//    @PostConstruct
//    public void init() {
////        try {
//        this.model = new LazyDataModel<Site>() {
//            private static final long serialVersionUID = 1L;
//
//                @Override
//            public List<Site> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//                List<Site> result = inventoryManagerEJB.getResultList(first, pageSize, sortField, sortOrder, filters);
//                model.setRowCount(inventoryManagerEJB.count(sortField, sortOrder, filters));
//                return result;
//            }
//        };
//    }
//
//    public LazyDataModel<Site> getModel() {
//        return model;
//    }
//
//    public void setModel(LazyDataModel<Site> model) {
//        this.model = model;
//    }
//}
