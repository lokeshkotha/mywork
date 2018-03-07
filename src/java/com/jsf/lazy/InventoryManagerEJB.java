///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.jsf.lazy;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import org.primefaces.model.SortOrder;
//
///**
// *
// * @author Lokesh Kotha
// */
//@Stateless
//public class InventoryManagerEJB {
//
//    @Inject
//    private BaseService baseService;
//
//    public List<Site> getResultList(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//        List<Site> all = new ArrayList<Site>();
//        all.addAll(this.baseService.getSiteDAO().getAll(first, pageSize, sortField, sortOrder, filters));
//        return all;
//    }
//
//    public int count(String sortField, SortOrder sortOrder, Map<String, String> filters) {
//        return this.baseService.getSiteDAO().getAll(-1, -1, null, null, filters).size();
//    }
//}
