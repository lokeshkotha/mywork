///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.jsf.lazy;
//
//import java.io.Serializable;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//import org.primefaces.component.column.Column;
//import org.w3c.dom.Entity;
//
///**
// *
// * @author Lokesh Kotha
// */
//@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
//public class Site implements Serializable {
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 8008732613898597654L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Nameable
//    @Column(nullable = false)
//    private String name;
//
//    private String ip;
//
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "siteTypeId")
//    private SiteType siteType;
//
//}
