///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.jsf.lazy;
//
//import java.io.Serializable;
//import java.util.logging.Logger;
//import javax.annotation.PostConstruct;
//import javax.faces.bean.ApplicationScoped;
//import javax.persistence.PersistenceContext;
//
///**
// *
// * @author Lokesh Kotha
// */
//@ApplicationScoped
//public class BaseService implements Serializable {
//
//    private static Logger log = Logger.getLogger(BaseService.class);
//
//    /*
//     * persistence
//     */
//    private static final long serialVersionUID = 588696475267901772L;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private SiteDAO siteDAO;
//
//    @PostConstruct
//    public void init() {
//        siteDAO = new SiteDAO(entityManager);
//    }
//
//    public SiteDAO getSiteDAO() {
//        return siteDAO;
//    }
